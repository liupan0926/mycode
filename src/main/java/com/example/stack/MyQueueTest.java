package com.example.stack;

import com.example.leetcode.MyQueue;

/**
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月20日 上午11:57:56
 *
 */
public class MyQueueTest {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();

		queue.push(2);
		queue.push(3);

		System.out.println(queue.peek());
		System.out.println(queue.pop());
		queue.push(4);
		System.out.println(queue.peek());

		System.out.println(queue.empty());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
