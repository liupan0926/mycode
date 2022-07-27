package com.example.application;

import java.io.Serializable;


/**
 * 
 * 类TestClass.java的实现描述：TODO 类实现描述 
 * @author liupan Jun 5, 2022 11:10:19 AM
 */
public class TestClass implements Serializable {

    @Override
    public String toString() {
        return "TestClass [name=" + name + ", id=" + id + "]";
    }

    /**
     * 
     */
    private static final long serialVersionUID = -2305271443381983912L;

    private String            name;

    private Long              id;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
