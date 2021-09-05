package com.example.application;

import java.util.LinkedHashMap;

/**
 * 主线程代码 类MainApplication.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Sep 4, 2021 11:22:41 AM
 */
public class MainApplication {

    public static void main(String[] args) {
        LinkedHashMap map = LRUCacheTest.init();
        System.out.println(map);
    }

}
