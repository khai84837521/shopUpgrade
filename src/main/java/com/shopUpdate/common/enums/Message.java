package com.shopUpdate.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {
    MEMBER_JOIN_SUCCESS("회원가입 되었습니다."),
    MEMBER_LOGOUT("로그아웃 되었습니다."),
    MEMBER_PASS_CHANGE_SUCCESS("비밀번호가 변경되었습니다."),
    MEMEBER_SESSION_NULL("로그인 후 이용해주세요");

    private final String message;


}
