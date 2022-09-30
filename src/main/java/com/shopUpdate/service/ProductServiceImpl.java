package com.shopUpdate.service;

import com.shopUpdate.domain.ProductDTO;
import com.shopUpdate.mapper.ProdListMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.inject.Inject;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{
    @Inject
    private ProdListMapper prodListMapper;

    @Override
    public List<ProductDTO> newProductList(){
        return prodListMapper.newProductList();
    }

    @Override
    public List<ProductDTO> productListCateSearchPopular(int cateCode) {
        return prodListMapper.productListCateSearchPopular(cateCode);
    }

    @Override
    public List<ProductDTO> productListPopular() {
        return prodListMapper.productListPopular();
    }
}

