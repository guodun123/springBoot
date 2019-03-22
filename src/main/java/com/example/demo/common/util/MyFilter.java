package com.example.demo.common.util;

import com.example.demo.common.exception.LoginStatusException;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 */
@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException  {
        //Object obj = JedisPoolUtil.get("loginName");
        /*if (null == obj) {
            throw  new ServletException("");
        }*/
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
