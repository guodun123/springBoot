package com.example.demo.controller;

import com.example.demo.common.ResponseHolder;
import com.example.demo.common.util.JedisPoolUtil;
import com.example.demo.model.Login;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public ModelAndView loginFtl(Model model) {
        return new ModelAndView("login/login");
    }

    @RequestMapping("login")
    public void login(String loginName, String password) {
        //JedisPoolUtil.set("LoginName","loginName",555555);
        loginService.checkPassword(loginName, password);
    }

    @RequestMapping("findPassword")
    public ModelAndView findPassword() {
        return new ModelAndView("login/find_password");
    }

    @RequestMapping("regist")
    public ModelAndView regist(Model model) {
        return new ModelAndView("login/regist");
    }

    @RequestMapping("addUser")
    @ResponseBody
    public ResponseHolder addUser(Login login) {
        loginService.addUser(login);
        return ResponseHolder.buildSuccessResponse();
    }

    @RequestMapping("validLoginName")
    @ResponseBody
    public ResponseHolder validLoginName(String loginName) {
        loginService.validLoginName(loginName);
        return ResponseHolder.buildSuccessResponse();
    }

    @RequestMapping("a")
    public ModelAndView a(Model model) {

        return new ModelAndView("index/menu");
    }

    @RequestMapping("b")
    public ModelAndView b(Model model) {
        return new ModelAndView("index/tesxt");
    }
}
