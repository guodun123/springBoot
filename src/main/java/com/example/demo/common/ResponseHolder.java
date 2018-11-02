package com.example.demo.common;

import java.io.Serializable;

public class ResponseHolder implements Serializable {
    private boolean success;
    private Object obj;
    private String message;

    public static ResponseHolder buildResponse() {
        return new ResponseHolder();
    }

    public static ResponseHolder buildSuccessResponse() {
        ResponseHolder rh = new ResponseHolder();
        return rh.success();
    }

    public static ResponseHolder buildFailResponse() {
        ResponseHolder rh = new ResponseHolder();
        return rh.fail();
    }

    public ResponseHolder fail() {
        this.success = false;
        return this;
    }

    public ResponseHolder success() {
        this.success = true;
        return this;
    }

    public ResponseHolder obj(Object obj) {
        this.obj = obj;
        return this;
    }

    public ResponseHolder message(String message) {
        this.message = message;
        return this;
    }

    public ResponseHolder() {
        this.success = true;
    }

    public ResponseHolder(boolean success) {
        this.success = success;
    }

    public ResponseHolder(boolean success, Object obj) {
        this.success = success;
        this.obj = obj;
    }

    public ResponseHolder(Object obj) {
        this.obj = obj;
        this.success = true;
    }

    public ResponseHolder(boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public ResponseHolder(String message) {
        this.message = message;
        this.success = true;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Object getObj() {
        return this.obj;
    }

    public String getMessage() {
        return this.message;
    }
}
