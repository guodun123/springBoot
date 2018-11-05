package com.example.demo.common;

import org.springframework.dao.DataIntegrityViolationException;
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
        if (e instanceof BusinessException){
            return ResponseHolder.buildFailResponse().message(((BusinessException) e).getCode());
        }
        if (e instanceof RuntimeException){
            return ResponseHolder.buildFailResponse().message("请联系管理员：" +e.getMessage());
        }
        if (e instanceof DataIntegrityViolationException){
            return ResponseHolder.buildFailResponse().message("数据异常，请联系管理员：" +e.getMessage());
        }
        return ResponseHolder.buildSuccessResponse();
    }
}
