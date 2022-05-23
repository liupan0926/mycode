package com.example.application.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 多线程Test实践 类ThreadTest1.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Sep 5, 2021 3:04:16 PM
 */
public class ThreadTest1 {

    static ThreadPoolExecutor executors = new ThreadPoolExecutor(2, 2, 30, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(500));

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            executors.execute(new GetInfoTest1(i));
        }
    }

}
