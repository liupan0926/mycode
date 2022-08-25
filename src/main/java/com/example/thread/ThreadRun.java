package com.example.thread;

public class ThreadRun implements Runnable {

	@Override
	public void run() {

		while (LockTest.num > 0) {
			LockTest.lockTickets();
		}
	}

}
