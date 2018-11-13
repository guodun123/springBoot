package com.example.demo.service.impl;

import com.example.demo.common.BusinessException;
import com.example.demo.login.dao.LoginDAO;
import com.example.demo.model.Login;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;

    @Override
    public Login insert(Login login) {
        loginDAO.insert(login);
        return login;
    }

    @Override
    public Login update(Login login) {
         loginDAO.update(login);
        return login;
    }

    @Override
    public void checkPassword(String loginName, String password) {
        Login login = this.selectByLoginName(loginName);
        if (null == login || !password.equals(login.getPassword())) {
            throw new BusinessException("登录名或密码错误!");
        }
    }

    @Override
    public Login selectByLoginName(String loginName) {
        Login login = new Login();
        login.setLoginName(loginName);
        List<Login> loginList = loginDAO.selectByContion(login);
        return !loginList.isEmpty() ? loginList.get(0) : null;
    }

    @Override
    public String adduser(Login var1) {
        this.insert(var1);
        return null;
    }

    @Override
    public void validLoginName(String loginName) {
        Login login = new Login();
        login.setLoginName(loginName);
        List<Login> loginList = loginDAO.selectByContion(login);
       if (!loginList.isEmpty()){
           throw new BusinessException("登陆名已存在!");
       }
    }
}
