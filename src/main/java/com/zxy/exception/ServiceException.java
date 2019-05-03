package com.zxy.exception;

public class ServiceException extends BaseException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Integer code) {
        super(message, code);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Integer code, Throwable cause) {
        super(message, code, cause);
    }
}
