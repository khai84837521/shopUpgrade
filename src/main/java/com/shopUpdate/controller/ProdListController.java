package com.shopUpdate.controller;

import com.shopUpdate.service.ProductService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

@Controller
public class ProdListController {
    @Inject
    private ProductService productService;

}
