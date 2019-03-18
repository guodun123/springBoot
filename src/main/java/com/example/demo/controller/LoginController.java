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
    @Autowired
    private JedisPoolUtil jedisPoolUtil;
    @RequestMapping("/")
    public ModelAndView loginFtl(Model model){
        model.addAttribute("zhangsan","lisi");
        return new ModelAndView("index");
    }
    @RequestMapping("login")
    @ResponseBody
    public ModelAndView login(String loginName,String password){
        //jedisPoolUtil.set("a","b",555555);
        //Object obj = jedisPoolUtil.get("a");
        //System.out.println(obj.toString());
        loginService.checkPassword(loginName,password);
        return new ModelAndView("index/menu");
    }
    @RequestMapping("findPassword")
    public ModelAndView findPassword(){
        return new ModelAndView("login/find_password");
    }

    @RequestMapping("regist")
    public ModelAndView regist(Model model){
        return new ModelAndView("login/regist");
    }
    @RequestMapping("addUser")
    @ResponseBody
    public ResponseHolder addUser(Login login){
        loginService.addUser(login);
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
    @RequestMapping("b")
    public ModelAndView b (Model model){
        model.addAttribute("a","asd");
        return new ModelAndView("index/menu");
    }
    @RequestMapping("c")
    public ModelAndView c (Model model){
        model.addAttribute("a","asd");
        return new ModelAndView("login/login");
    }
}
