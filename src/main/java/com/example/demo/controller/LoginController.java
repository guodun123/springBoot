package com.example.demo.controller;

import com.example.demo.common.ResponseHolder;
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
    public ModelAndView loginFtl(){
        return new ModelAndView("index");
    }
    @RequestMapping("login")
    @ResponseBody
    public ResponseHolder login(String loginName,String password){
        loginService.checkPassword(loginName,password);
        return ResponseHolder.buildSuccessResponse();
    }
    @RequestMapping("findPassword")
    public ModelAndView findPassword(){
        return new ModelAndView("login/find_password");
    }
    @RequestMapping("regist")
    public ModelAndView regist(){
        return new ModelAndView("login/regist");
    }
    @RequestMapping("addUser")
    @ResponseBody
    public ResponseHolder addUser(Login login){
        loginService.adduser(login);
        return ResponseHolder.buildSuccessResponse();
    }
    @RequestMapping("validLoginName")
    @ResponseBody
    public ResponseHolder validLoginName(String  loginName){
        loginService.validLoginName(loginName);
        return ResponseHolder.buildSuccessResponse();
    }

    @RequestMapping("a")
    public ModelAndView a (Model model){
        model.addAttribute("a","asd");
        return new ModelAndView("index/tesxt");
    }
}
