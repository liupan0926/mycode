package com.example.sort;

public class RunableApplication {

    public static void main(String[] args) {

        Runnable run = new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "_world");
            }
        };

        Thread r = new Thread(run);

        r.start();
        //r.run();

        System.out.println(Thread.currentThread().getName() + "_hello");
    }

}
