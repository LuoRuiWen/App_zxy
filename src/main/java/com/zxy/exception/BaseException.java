package com.zxy.exception;

public class BaseException extends RuntimeException {
    private Integer code;

    private String message;

    public BaseException(String message) {
        this.message = message;
    }

    public BaseException(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    public BaseException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public BaseException(String message, Integer code, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        try {
            return message;
        } catch (Exception e) {
            return message;
        }
    }
}
