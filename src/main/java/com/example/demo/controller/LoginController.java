package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping({"/","/index"})
    public String index(Model model) {
        return "index";
    }

    /**
     * 登录页面
     * @param request - HttpServletRequest
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/toLogin")
    public String login(HttpServletRequest request , Model model) {
        return "login";
    }


    /**
     * 登录验证页面
     * @return String
     * @throws Exception
     */
    @PostMapping(value="/check")
    public String loginCheck(Model model,User user) {
        //验证登录
        //UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        model.addAttribute("user",user);
        return "index";
    }

}
