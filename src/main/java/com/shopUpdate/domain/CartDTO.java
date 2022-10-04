package com.shopUpdate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDTO {
    private int cartId;
    private String memberId;
    private int productId;
    private String prodTitle;
    private int prodPrice;
    private String prodThumbnail;
    private int amount;

}
