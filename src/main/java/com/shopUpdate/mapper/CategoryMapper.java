package com.shopUpdate.mapper;

import com.shopUpdate.domain.CategoryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    public List<CategoryDTO> cateList();

    List<CategoryDTO> selectCateList();

    CategoryDTO selectParentCate(@Param("cateCode") int cateCode);

    List<CategoryDTO> selectSubCateList(@Param("parentCateCode") int cateCode);

    CategoryDTO selectCate(@Param("cateCode") int cateCode);
}
