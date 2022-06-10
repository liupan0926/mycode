package com.example.dubbo.service.provider;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * dubbo 服务端 服务实现 类HelloServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author liupan May 27, 2022 4:11:12 PM
 */

@Service
public class HelloServiceImpl implements HelloService, ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public String sayHello(String word) {
        String threadName = Thread.currentThread().getName() + "_" + word;
        UserService userService = (UserService) context.getBean("userService");

        User user = new User();

        user.setUserName(threadName);
        user.setPassWord("default");
        user.setRealName(word);

        userService.InsertUser(user);

        return threadName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
