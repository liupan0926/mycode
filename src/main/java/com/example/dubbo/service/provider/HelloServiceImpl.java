package com.example.dubbo.service.provider;

/**
 * dubbo 服务端 服务实现 类HelloServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author liupan May 27, 2022 4:11:12 PM
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String word) {
        String threadName = Thread.currentThread().getName();
        return threadName + "_" + word;
    }

}
