package com.example.application.thread;

/**
 * 类GetInfoTest1.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Sep 5, 2021 3:42:20 PM
 */
public class GetInfoTest1 implements Runnable {

    private int number;

    public GetInfoTest1(int i) {
        this.number = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",number:" + number);
    }

}
