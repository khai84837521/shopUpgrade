package com.shopUpdate.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    MEMBER_LOGIN_FAIL("로그인 실패"),
    MEMBER_JOIN_FAIL("회원가입 중 오류가 발생하였습니다.");

    private final String errorMsg;

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}