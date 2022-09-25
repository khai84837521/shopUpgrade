package com.shopUpdate.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    public String url;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ErrorCode errorCode, String url) {
        super(errorCode.getErrorMsg());
        this.url = url;
    }


    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
