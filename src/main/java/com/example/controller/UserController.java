package com.example.controller;

import javax.annotation.Resource;

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
}
