package com.shopUpdate.service;

import com.shopUpdate.domain.CartDTO;
import com.shopUpdate.mapper.CartMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Inject
    private CartMapper cartMapper;

    @Override
    public List<CartDTO> getCartList(String memberId) {
        return cartMapper.selectCartList(memberId);
    }

    @Override
    @Transactional
    public int setCart(CartDTO cartDTO) {
        cartMapper.insertCart(cartDTO);

        return cartMapper.selectCartCount(cartDTO.getMemberId());
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

    @Override
    public int getCartCount(String memberId) {
        return cartMapper.selectCartCount(memberId);
    }
}
