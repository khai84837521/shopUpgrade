package com.shopUpdate.controller.product;

import com.shopUpdate.controller.product.form.SearchProduct;
import com.shopUpdate.controller.product.view.ProductView;
import com.shopUpdate.domain.CategoryDTO;
import com.shopUpdate.domain.ProductDTO;
import com.shopUpdate.service.CategoryService;
import com.shopUpdate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/{cateCode}")
    public String listView(SearchProduct searchProduct, Model model, @PathVariable int cateCode){
        searchProduct.setCateCode(cateCode);
        List<CategoryDTO> categoryList = categoryService.getCateList();
        CategoryDTO parentCategory = categoryService.getParentCate(searchProduct.getCateCode());
        List<CategoryDTO> subCategoryList = categoryService.getSubCate(parentCategory.getCate_code());



        model.addAttribute("category", categoryList);
        model.addAttribute("parentCategory", parentCategory);
        model.addAttribute("subCategoryList", subCategoryList);
        model.addAttribute("searchProduct", searchProduct);
        return "/product/product-list";
    }

    @GetMapping("/{cateCode}/list")
    public String list(SearchProduct searchProduct, Model model, @PathVariable int cateCode){
        if (searchProduct.getSearchCate() != null) {
            searchProduct.setSearchCateList(searchProduct.getSearchCate().split(","));
        } else {
            ProductView productView = new ProductView();
            productView.setCount(0);
            productView.setProductList(new ArrayList<>());
            model.addAttribute("productView", productView);
            model.addAttribute("searchProduct", searchProduct);
            return "/product/product-list-data";
        }

        CategoryDTO cate = categoryService.getCate(cateCode);

        ProductView productView = new ProductView();
        productView.setCount(productService.getProductListCount(searchProduct, searchProduct.getCateCode()));
        productView.setProductList(productService.getProductList(searchProduct, searchProduct.getCateCode()));
        productView.setCategory(cate);

        model.addAttribute("productView", productView);
        model.addAttribute("searchProduct", searchProduct);
        return "/product/product-list-data";
    }


    @GetMapping("/goods/{productId}")
    public String productDetail(@PathVariable int productId, Model model){
        ProductDTO productGoods = productService.getProductGoods(productId);
        model.addAttribute("productGoods", productGoods);
        return "/goods_view";
    }
}
