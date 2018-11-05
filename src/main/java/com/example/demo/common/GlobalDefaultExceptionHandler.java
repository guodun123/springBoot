package com.example.demo.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
// 全局异常捕获

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseHolder defaultExceptionHandler(HttpServletRequest req, Exception e) {
        return ResponseHolder.buildFailResponse().obj(e);
    }
}
