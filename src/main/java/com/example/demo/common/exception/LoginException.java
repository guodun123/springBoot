package com.example.demo.common.exception;

public class LoginException extends RuntimeException {
    private String code;
    private String[] params;

    public LoginException(String code) {
        this.code = code;
    }

    public LoginException(String code, String... params) {
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
