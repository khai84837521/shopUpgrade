package com.shopUpdate.controller;

import com.shopUpdate.domain.CategoryDTO;
import com.shopUpdate.domain.ProductDTO;
import com.shopUpdate.service.CategoryService;
import com.shopUpdate.service.ProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.inject.Inject;

@Controller
public class MainController {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;


    @GetMapping("/main")
    public String index( Model model) {
        List<ProductDTO> newProductList = productService.newProductList();
        model.addAttribute("newProductList", newProductList);

        List<ProductDTO> productListPopular = productService.productListPopular();
        model.addAttribute("productListPopular", productListPopular);

        List<CategoryDTO> cateList = categoryService.cateList();
        model.addAttribute("cateList", cateList);

        return "main";
    }

    @GetMapping("/item")
    public String item(){
        return "item";
    }

    @GetMapping("/subAll")
    public String subAll(){
        return "subpage/subAll";
    }


    @GetMapping("/item1")
    public String item1(){
        return "item1";
    }

    // prodListController로 이동?
    @GetMapping("/main/cateCodeSearch")
    public String mainCateCodeSearch(@RequestParam(name = "cateCode", defaultValue = "0") int cateCode,
                                               Model model){
        List<ProductDTO> productListCateSearchPopular = productService.productListCateSearchPopular(cateCode);
        model.addAttribute("productListCateSearchPopular", productListCateSearchPopular);
        return "/include/productList";
    }

}
