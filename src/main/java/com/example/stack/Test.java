package com.example.stack;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		stack.push("123");

		stack.push("456");

		System.out.println(stack.pop());

	}
}
