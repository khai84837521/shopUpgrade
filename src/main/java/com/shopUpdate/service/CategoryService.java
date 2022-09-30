package com.shopUpdate.service;

import com.shopUpdate.domain.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> cateList();

    List<CategoryDTO> getCateList();

    CategoryDTO getParentCate(int cateCode);

    List<CategoryDTO> getSubCate(int cateCode);

    CategoryDTO getCate(int cateCode);
}
