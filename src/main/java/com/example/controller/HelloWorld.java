package com.example.controller;

import javax.annotation.Resource;

import com.example.dubbo.service.provider.HelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Resource
    private HelloService helloService;

    @RequestMapping("hello/{name}")
    public String Hello(@PathVariable String name) {

        String result = helloService.sayHello(name);

        return result;
    }
}
