package com.shopUpdate.service;

import com.shopUpdate.controller.product.form.SearchProduct;
import com.shopUpdate.domain.ProductDTO;
import com.shopUpdate.mapper.ProdListMapper;
import org.springframework.stereotype.Service;

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

    @Override
    public List<ProductDTO> getProductList(SearchProduct searchProduct, int cateCode) {
        return prodListMapper.selectProductList(searchProduct, cateCode);
    }

    @Override
    public int getProductListCount(SearchProduct searchProduct, int cateCode) {
        return prodListMapper.countProductList(searchProduct, cateCode);
    }
}

