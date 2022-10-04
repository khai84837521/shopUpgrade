package com.shopUpdate.service;

import com.shopUpdate.controller.cart.CartView;
import com.shopUpdate.domain.CartDTO;
import com.shopUpdate.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Inject
    private CartMapper cartMapper;

    @Override
    public void getCartList(String memberId) {
        CartView cartView = new CartView();
        cartView.setCartCount(cartMapper.selectCartCount(memberId));
        cartView.setCartList(cartMapper.selectCartList(memberId));

    }

    @Override
    public int setCart(CartDTO cartDTO) {
        String memberId = cartDTO.getMemberId();
        System.out.println(memberId);
        int productId = cartDTO.getProductId();
        cartMapper.selectCartOne(memberId, productId).getAmount();

        int cartCountRetv = 0;
        int cartCount = 0;
        if(cartCountRetv == 0){
            cartMapper.insertCart(cartDTO);
            cartCount = cartMapper.selectCartCount(memberId);
        }else{
            cartCount = cartCountRetv + cartDTO.getAmount();
            cartDTO.setAmount(cartCount);
            cartMapper.updateCart(cartDTO);
        }

        return cartCount;
    }

    @Override
    public int update(CartDTO cartDTO) {
        cartMapper.updateCart(cartDTO);
        int cartCount = cartMapper.selectCartCount(cartDTO.getMemberId());
        return cartCount;
    }

    @Override
    public int deleteCart(String memberId, int productId) {
        cartMapper.deleteCart(memberId, productId);
        int cartCount = cartMapper.selectCartCount(memberId);
        return cartCount;
    }

    @Override
    public int deleteAllCart(String memberId) {
        cartMapper.deleteAllCart(memberId);
        int cartCount = cartMapper.selectCartCount(memberId);
        return cartCount;
    }
}
