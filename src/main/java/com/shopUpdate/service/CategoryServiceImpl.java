package com.shopUpdate.service;

import com.shopUpdate.domain.CategoryDTO;
import com.shopUpdate.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Inject
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> cateList() {
        return categoryMapper.cateList();
    }

}
