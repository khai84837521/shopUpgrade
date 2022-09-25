package com.shopUpdate.domain;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class MemberDTO {
    private String memId;
    private String memPw;
    private String memNm;
    private String date;
    private String mal_cert;
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

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getMemNm() {
        return memNm;
    }

    public void setMemNm(String memNm) {
        this.memNm = memNm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMal_cert() {
        return mal_cert;
    }

    public void setMal_cert(String mal_cert) {
        this.mal_cert = mal_cert;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressSub() {
        return addressSub;
    }

    public void setAddressSub(String addressSub) {
        this.addressSub = addressSub;
    }

    public String getAddressReference() {
        return addressReference;
    }

    public void setAddressReference(String addressReference) {
        this.addressReference = addressReference;
    }

    public String getAccumulation() {
        return Accumulation;
    }

    public void setAccumulation(String accumulation) {
        Accumulation = accumulation;
    }

    public String getMemberFA() {
        return memberFA;
    }

    public void setMemberFA(String memberFA) {
        this.memberFA = memberFA;
    }

}
