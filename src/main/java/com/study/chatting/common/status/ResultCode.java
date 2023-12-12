package com.study.chatting.common.status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {
    SUCCESS("success"),
    FAIL("failure"),
    NOT_FOUND("not found"),
    ;

    private final String code;
}
