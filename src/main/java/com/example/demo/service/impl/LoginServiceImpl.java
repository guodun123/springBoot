package com.example.demo.service.impl;

import com.example.demo.dao.LoginDAO;
import com.example.demo.model.Login;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
       /* if (password.equals(login.getPassword())) {
        }*/
        System.out.println(22);

    }

    @Override
    public Login selectByLoginName(String loginName) {
        Login login = new Login();
        login.setLoginName(loginName);
        List<Login> loginList = loginDAO.selectByContion(login);
        return !loginList.isEmpty() ? (Login)loginList.get(0) : null;
    }

    @Override
    public String adduser(Login var1) {
        this.insert(var1);
        return null;
    }
}
