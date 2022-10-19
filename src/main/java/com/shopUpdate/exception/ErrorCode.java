package com.shopUpdate.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    MEMBER_LOGIN_FAIL("로그인 실패"),
    MEMBER_JOIN_FAIL("회원가입 중 오류가 발생하였습니다."),
    MEMEBER_SESSION_NULL("로그인 후 이용해주세요");

    private final String errorMsg;

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}