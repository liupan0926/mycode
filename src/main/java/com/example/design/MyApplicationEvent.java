package com.example.design;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {

    /**
     * 
     */
    private static final long serialVersionUID = 2847533635362718171L;
    private String message;

    public MyApplicationEvent(Object source, String msg) {
        super(source);
        this.setMessage(msg);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
