package com.shopUpdate.service;

import com.shopUpdate.domain.ProductDTO;

import java.util.List;


public interface ProductService {
    List<ProductDTO> newProductList();
    List<ProductDTO> productListCateSearchPopular(int cateCode);
    List<ProductDTO> productListPopular();
}
