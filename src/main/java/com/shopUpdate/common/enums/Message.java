package com.shopUpdate.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {
    MEMBER_JOIN("회원가입 되었습니다.");

    private String message;
}
