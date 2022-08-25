package com.example.thread;

public class ThreadTest {

	public static void main(String[] args) {

		Thread t1 = new MyThread(0);

		Thread t2 = new MyThread(1);
		Thread t3 = new MyThread(2);
		Thread t4 = new MyThread(3);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
