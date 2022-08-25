package com.example.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

	private static AtomicInteger cnt = new AtomicInteger(0);

	private int id;

	public MyThread(int id) {
		this.id = id;
	}

	@Override
	public void run() {

		while (cnt.get() < 100) {

			if (cnt.get() % 4 == id) {
				System.out.println(Thread.currentThread().getName() + "_" + (id) + "," + cnt);
				cnt.incrementAndGet();
			}
		}
	}

}
