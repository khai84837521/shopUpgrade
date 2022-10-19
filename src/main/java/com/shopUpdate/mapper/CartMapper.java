package com.shopUpdate.mapper;

import com.shopUpdate.domain.CartDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int selectCartCount(String memberId);
    List<CartDTO> selectCartList(String memberId);
    int insertCart(CartDTO cartDTO);
    int updateCart(CartDTO cartDTO);
    int deleteCart(@Param("memberId") String memberId, @Param("cartId") int cartId);
    int deleteAllCart(String memberId);
    CartDTO selectCartOne(String memberId, int productId);
}
