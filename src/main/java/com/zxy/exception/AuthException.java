/*
 * Copyright 2019 the original author or authors.
 */
package com.zxy.exception;

/**
 * @author ygk
 * @date 2019-03-16
 */
public class AuthException extends BaseException {

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Integer code) {
        super(message, code);
    }

    public AuthException(String message, Integer code, Throwable cause) {
        super(message, code, cause);
    }
}
