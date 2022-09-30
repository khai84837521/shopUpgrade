package com.shopUpdate.mapper;

import com.shopUpdate.domain.ProductDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProdListMapper {
    List<ProductDTO> newProductList();
    List<ProductDTO> productListCateSearchPopular(@Param(value = "cateCode") int cateCode);
    List<ProductDTO> productListPopular();
}
