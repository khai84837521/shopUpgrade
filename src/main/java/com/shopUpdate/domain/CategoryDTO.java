package com.shopUpdate.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDTO {
    private String cate_name;
    private int cate_code;
    private int parent_cate_code;
}
