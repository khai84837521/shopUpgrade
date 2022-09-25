package com.shopUpdate.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RedirectUrl {
    MAIN("/main", "메인 페이지"),
    MEMBER_JOIN("/member/join", "회원가입 페이지");

    private final String url;
    private final String description;
}
