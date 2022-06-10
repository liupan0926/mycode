package com.example.demo;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor2 implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("userService".equalsIgnoreCase(beanName)) {
            System.out.println("B初始化 before--实例化的bean对象:" + bean + "\t" + beanName);
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
