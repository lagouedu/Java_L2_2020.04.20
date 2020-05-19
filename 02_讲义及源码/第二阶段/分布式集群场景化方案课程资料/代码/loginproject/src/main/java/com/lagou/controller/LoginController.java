package com.lagou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("toLogin")
    public String toLogin() {
        System.out.println("================++++++++++++++跳转登录页面");
        return "login";
    }

    @RequestMapping("loginSystem")
    public String loginSystem(String username, String password, HttpSession session) {
        // 合法用户，信息写入session，同时跳转到系统主页面
        if("admin".equals(username) && "admin".equals(password)) {
            System.out.println("合法用户");
            session.setAttribute("username",username + System.currentTimeMillis());
            return "redirect:/demo/result";
        }else{
            // 非法用户返回登录页面
            System.out.println("非法，跳转");
            return "redirect:/login/toLogin";
        }
    }
}
