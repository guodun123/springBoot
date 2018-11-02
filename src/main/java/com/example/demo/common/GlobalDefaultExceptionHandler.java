package com.example.demo.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
// 全局异常捕获

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody // 如果返回String或json要加此注解如果返回界面就不加
    public String defaultExceptionHandler(HttpServletRequest req, Exception e) {
        // 返回String
        return "请联系管理员："+e;
        // 返回View 创建
        //ModelAndView mv = new ModelAndView("error");
    }
}
