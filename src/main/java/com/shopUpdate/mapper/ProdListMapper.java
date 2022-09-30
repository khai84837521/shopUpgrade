package com.shopUpdate.mapper;

import com.shopUpdate.controller.product.form.SearchProduct;
import com.shopUpdate.domain.ProductDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProdListMapper {
    List<ProductDTO> newProductList();
    List<ProductDTO> productListCateSearchPopular(@Param(value = "cateCode") int cateCode);
    List<ProductDTO> productListPopular();

    List<ProductDTO> selectProductList(@Param(value = "searchProduct") SearchProduct searchProduct, @Param(value = "cateCode") int cateCode);

    int countProductList(@Param(value = "searchProduct") SearchProduct searchProduct, @Param(value = "cateCode") int cateCode);
}
