package com.shopUpdate.controller.cart;

import lombok.Data;

@Data
public class CartForm {

    private int memberId;
    private int productId;
    private String prodTitle;
    private int prodPrice;
    private String prodThumbnail;
    private int amount;
}
