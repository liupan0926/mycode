package com.example.design;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListenner implements ApplicationListener<MyApplicationEvent> {

    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("接收到的信息是：" + event.getMessage());
    }

}
