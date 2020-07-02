package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户列表
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String userList(Model model){
        List<User> users = userService.findAll();

        //users.add(new User(1L, "admin", new BCryptPasswordEncoder().encode("123456"), null));
        //users.add(new User(2L, "user", new BCryptPasswordEncoder().encode("123456"), null));
        //查询用户的列表
        model.addAttribute("users",users);
        return "user/list";
    }

    /**
     * 增加
     */
    @RequestMapping("/add")
    public String add(){
        return "add";
    }


    /**
     * 修改
     */
    @RequestMapping("/modify")
    public String modify(){
        return "add";
    }


    /**
     * 保存
     */
    @RequestMapping("/addSave")
    public void addSave(User user){
        userService.save(user);
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void del(User user){
        userService.delete(user);
    }

}
