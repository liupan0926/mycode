package com.example.design;

/**
 * 单例模式
 * 
 * @author liupan Jun 12, 2022 3:33:48 PM
 */
public class SingleExampleModel {

    private static volatile SingleExampleModel instance  = null;

    private static SingleExampleModel          instance2 = null;

    public static SingleExampleModel getInstance() {
        if (instance == null) {
            synchronized (SingleExampleModel.class) {
                if (instance == null) {
                    instance = new SingleExampleModel();
                }
            }
        }
        return instance;
    }

    public static SingleExampleModel getInstance2() {
        if (instance2 == null) {
            instance2 = new SingleExampleModel();
        }
        return instance2;
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "_" + SingleExampleModel.getInstance());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "_" + SingleExampleModel.getInstance());
            }
        });
        try {
            t1.start();
            t2.start();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            t1.interrupt();
            t2.interrupt();
        }

    }
}
