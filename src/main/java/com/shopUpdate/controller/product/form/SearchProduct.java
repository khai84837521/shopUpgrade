package com.shopUpdate.controller.product.form;

import com.shopUpdate.domain.CategoryDTO;
import lombok.Data;

import java.util.List;

@Data
public class SearchProduct {
    private String keyword;
    // Integer 쓰는 이유 -> null 을 허용하기 위해 (박싱)
    private Integer minPrice;
    private Integer maxPrice;

    private int cateCode;
    private String searchCate;
    private String[] searchCateList;
    private List<CategoryDTO> category;
    private String orderType;

    private int page = 1;
    private int pageSize = 30;

    public int getStartPage() {
        return (page - 1) * pageSize;
    }
}
