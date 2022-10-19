package com.shopUpdate.service.product;

import com.shopUpdate.controller.product.form.SearchProduct;
import com.shopUpdate.domain.ProductDTO;

import java.util.List;


public interface ProductService {
    List<ProductDTO> newProductList();
    List<ProductDTO> productListCateSearchPopular(int cateCode);
    List<ProductDTO> productListPopular();

    List<ProductDTO> getProductList(SearchProduct searchProduct, int cateCode);

    int getProductListCount(SearchProduct searchProduct, int cateCode);

    ProductDTO getProductGoods(int productId);
}
