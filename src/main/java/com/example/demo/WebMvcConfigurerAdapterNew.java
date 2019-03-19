package com.example.demo;

import com.example.demo.common.util.MyIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class WebMvcConfigurerAdapterNew extends WebMvcConfigurerAdapter {
    @Autowired
    private MyIntercept intercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(intercept).addPathPatterns("/**");
    }
}
