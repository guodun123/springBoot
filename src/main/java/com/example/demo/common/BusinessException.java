package com.example.demo.common;

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
