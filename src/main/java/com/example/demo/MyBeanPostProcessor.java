package com.example.demo;

import com.example.design.DemoPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 类MyBeanPostProcessor.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 8, 2022 3:45:51 PM
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Autowired
    private DemoPublisher demoPublisher;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("userService".equalsIgnoreCase(beanName)) {
            System.out.println("A初始化 before--实例化的bean对象:" + bean + "\t" + beanName);

            demoPublisher.publist("测试事件发布A初始化");
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }

}
