package com.shopUpdate.service.category;

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

    @Override
    public List<CategoryDTO> getCateList() {
        return categoryMapper.selectCateList();
    }

    @Override
    public CategoryDTO getParentCate(int cateCode) {
        return categoryMapper.selectParentCate(cateCode);
    }

    @Override
    public List<CategoryDTO> getSubCate(int cateCode) {
        return categoryMapper.selectSubCateList(cateCode);
    }

    @Override
    public CategoryDTO getCate(int cateCode) {
        return categoryMapper.selectCate(cateCode);
    }
}
