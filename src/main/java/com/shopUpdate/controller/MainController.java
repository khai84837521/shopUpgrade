package com.shopUpdate.controller;

import com.shopUpdate.domain.CategoryDTO;
import com.shopUpdate.domain.MemberDTO;
import com.shopUpdate.domain.ProductDTO;
import com.shopUpdate.service.CartService;
import com.shopUpdate.service.CategoryService;
import com.shopUpdate.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private CartService cartService;

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




    @GetMapping("/item1")
    public String item1(){
        return "product-list";
    }

    // prodListController로 이동?
    @GetMapping("/main/cateCodeSearch")
    public String mainCateCodeSearch(@RequestParam(name = "cateCode", defaultValue = "0") int cateCode,
                                               Model model){
        List<ProductDTO> productListCateSearchPopular = productService.productListCateSearchPopular(cateCode);
        model.addAttribute("productListCateSearchPopular", productListCateSearchPopular);
        return "/include/productList";
    }

    @GetMapping("/header")
    public String header(Model model, HttpSession session) {
        if (session.getAttribute("userInfo") != null) {
            MemberDTO memberDTO = (MemberDTO) session.getAttribute("userInfo");
            model.addAttribute("cartCount", cartService.getCartCount(memberDTO.getMember_id()));
        } else {
            model.addAttribute("cartCount", 0);
        }
        return "/include/header";
    }

}
