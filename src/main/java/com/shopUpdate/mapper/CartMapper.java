package com.shopUpdate.mapper;

import com.shopUpdate.domain.CartDTO;

import java.util.List;

public interface CartMapper {
    int selectCartCount(String memberId);
    List<CartDTO> selectCartList(String memberId);
    int insertCart(CartDTO cartDTO);
    int updateCart(CartDTO cartDTO);
    int deleteCart(String memberId, int productId);
    int deleteAllCart(String memberId);
    CartDTO selectCartOne(String memberId, int productId);
}
