package com.example.thread;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class LockTest {

	// 10张票
	public static volatile int num = 100000;

	private static AtomicBoolean isLock = new AtomicBoolean(false);

	private static final Queue<Thread> WAIT_QUEUE = new LinkedBlockingQueue<>();

	public static void lockTickets() {
		while (!lock()) {
			// 自旋锁 cpu空转，浪费资源
			// Thread.yield();// 线程从运行状态到就绪状态，让出cpu,
			// 主要适用于两个线程竞争，线程太多，也会增加开销

			// 线程添加到队列
			lockWait();

		}
		if (num > 0) {
			// System.out.println(Thread.currentThread().getName() + ",抢票成功");
			num = num - 1;
			// System.out.println("剩下库存:" + num);
		} else {
			Long end = System.currentTimeMillis();
			System.out.println("end:" + end + ",name:" + Thread.currentThread().getName());
		}
		unLock();
	}

	public static void lockWait() {
		WAIT_QUEUE.add(Thread.currentThread());
		System.out.println(Thread.currentThread().getName() + ",进入等待队列");
		LockSupport.park();
	}

	public static boolean lock() {
		return isLock.compareAndSet(false, true);
	}

	public static void unLock() {
		isLock.set(false);

		Thread t = WAIT_QUEUE.poll();
		if (t != null) {
			System.out.println(t.getName() + ",获取锁");
			LockSupport.unpark(t);
		}
	}

	public static void main(String[] args) {

		Long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new ThreadRun());
			t.setName("test" + i);
			t.start();
		}

		System.out.println("start:" + start);

	}
}
