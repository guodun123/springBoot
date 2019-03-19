package com.example.demo.common.exception;

public class LoginStatusException extends Exception {
    private String code;
    private String[] params;

    public LoginStatusException(String code) {
        this.code = code;
    }

    public LoginStatusException(String code, String... params) {
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
