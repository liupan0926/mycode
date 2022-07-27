package com.example.design;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {

    @Autowired
    ApplicationContext context;

    public void publist(String message) {
        MyApplicationEvent myEvent = new MyApplicationEvent(this, message);
        context.publishEvent(myEvent);
    }

}
