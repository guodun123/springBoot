package com.example.demo.common.exception;

/**
 * 业务异常
 * 一般用来对业务数据校验抛出的异常
 */
public class BusinessException extends RuntimeException {
    private String code;
    private String[] params;

    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(String code, String... params) {
        this.code = code;
        this.params = params;
    }

    public String getCode() {
        return this.code;
    }

    public String[] getParams() {
        return this.params;
    }
}
