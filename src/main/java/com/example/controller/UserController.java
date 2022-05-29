package com.example.controller;

import javax.annotation.Resource;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id) {
        return userService.Sel(id).toString();
    }

    @RequestMapping("insertUser/{name}")
    public Integer insertUser(@PathVariable String name) {

        User user = new User();
        user.setUserName(name);
        user.setPassWord("default");
        user.setRealName("real_" + name);
        return userService.InsertUser(user);
    }
}
