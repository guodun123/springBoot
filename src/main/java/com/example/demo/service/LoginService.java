package com.example.demo.service;


import com.example.demo.common.BusinessException;
import com.example.demo.model.Login;

public interface LoginService {
    Login insert(Login var1);

    Login update(Login var1);

    void checkPassword(String var1, String var2) throws BusinessException;

    Login selectByLoginName(String var1);
    String adduser(Login var1);
    void  validLoginName(String  loginName);
}

