package com.example.demo.controller;

import com.example.demo.common.ResponseHolder;
import com.example.demo.common.util.JedisPoolUtil;
import com.example.demo.model.Login;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserPermissionsService userPermissionsService;

    @RequestMapping("/")
    public ModelAndView loginFtl(Model model) {
        return new ModelAndView("login/login");
    }

    @RequestMapping("login")
    public void login(String loginName, String password, HttpServletRequest request, HttpServletResponse response) {
        loginService.checkPassword(loginName, password,request,response);
    }
    @RequestMapping("/hello")
    public String hello(Model model) {
        return "home/homepage1";
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
       model.addAttribute("menus",userPermissionsService.findUserPermissionByUserId(1L)) ;
        return new ModelAndView("index/menu");
    }

    @RequestMapping("b")
    public ModelAndView b(Model model) {
        return new ModelAndView("index/tesxt");
    }
    @RequestMapping("c")
    public ModelAndView c(Model model) {
        return new ModelAndView("index");
    }
    @RequestMapping("d")
    public ModelAndView d(Model model) {
        return new ModelAndView("home/console");
    }
}
