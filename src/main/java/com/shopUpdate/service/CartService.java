package com.shopUpdate.service;

import com.shopUpdate.domain.CartDTO;

import java.util.List;

public interface CartService {
    void getCartList(String memberId);
    int setCart(CartDTO cartDTO);
    int update(CartDTO cartDTO);
    int deleteCart(String memberId, int productId);
    int deleteAllCart(String memberId);
}
