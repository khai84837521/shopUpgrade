package com.shopUpdate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class ProductDTO {
    private int product_id;
    private int cate_code;
    private String title;
    private String thumbnail;
    private int zzim;
    private int star_count;
    private String prod_des_img;
    private int price;
    private int discount_price;
    private String brand;
    private int order_count;
    private Date create_dt;
    private String des_short;
}
