package com.example.demo.service;


import com.example.demo.common.exception.BusinessException;
import com.example.demo.common.baseclass.BaseService;
import com.example.demo.model.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService extends BaseService<Login> {

    void checkPassword(String var1, String var2 ,HttpServletRequest request, HttpServletResponse response) throws BusinessException;

    Login selectByLoginName(String var1);

    void addUser(Login var1);

    void validLoginName(String loginName);
}

