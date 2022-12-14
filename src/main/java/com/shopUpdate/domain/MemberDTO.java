package com.shopUpdate.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    public static final String SESSION_NAME = "userInfo";

    private String member_id;
    private String memPw;
    private String memNm;
    private String date;
    private String malCert;
    private String email;
    private String phone;
    private String birthDt;
    private String zipcode;
    private String address;
    private String addressSub;
    private String addressReference;
    private String Accumulation;
    private String memberFA;
    private String column;
    private String userInfo;
}
