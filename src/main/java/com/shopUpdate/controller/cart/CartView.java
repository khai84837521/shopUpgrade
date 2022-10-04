package com.shopUpdate.controller.cart;

import com.shopUpdate.domain.CartDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CartView {

    private int cartCount;
    private List<CartDTO> cartList;
}
