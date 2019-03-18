package com.example.demo.service;


import com.example.demo.common.BusinessException;
import com.example.demo.common.baseclass.BaseService;
import com.example.demo.model.Login;

public interface LoginService extends BaseService<Login> {

    void checkPassword(String var1, String var2) throws BusinessException;

    Login selectByLoginName(String var1);

    void addUser(Login var1);

    void validLoginName(String loginName);
}

