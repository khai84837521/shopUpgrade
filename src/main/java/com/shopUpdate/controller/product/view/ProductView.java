package com.shopUpdate.controller.product.view;

import com.shopUpdate.domain.CategoryDTO;
import com.shopUpdate.domain.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductView {
    private int count;
//    private List<CategoryDTO> cateSubList;
    private CategoryDTO category;
    private List<ProductDTO> productList;
}
