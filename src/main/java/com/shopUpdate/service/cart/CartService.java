package com.shopUpdate.service.cart;

import com.shopUpdate.domain.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> getCartList(String memberId);
    int setCart(CartDTO cartDTO);
    int update(CartDTO cartDTO);
    int deleteCart(String memberId, int cartId);
    int deleteAllCart(String memberId);
    int getCartCount(String memberId);
}
