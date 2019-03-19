package com.example.demo.common.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
// 全局异常捕获

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest req, Exception e) {
        if (e instanceof BusinessException) {
            return ((BusinessException) e).getCode();
        }
        if (e instanceof LoginStatusException) {
            return "请重新登陆！";
        }
        if (e instanceof RuntimeException) {
            return "请联系管理员：" + e.getMessage();
        }
        if (e instanceof DataIntegrityViolationException) {
            return "数据异常，请联系管理员：" + e.getMessage();
        }
        return "";
    }
}