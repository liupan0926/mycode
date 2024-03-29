package com.example.leetcode;

import java.util.Stack;

/**
 * <pre>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false
说明：

你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * </pre>
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 类Solution232.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 28, 2022 3:43:48 PM
 */
public class MyQueue {

	// 输入队列
	private Stack<Integer> inputStack;

	// 输出队列
	private Stack<Integer> outputStack;

	/**
	 * 1,2 进入输入栈 [1,2],2会先出 出栈，进入输出栈 [2,1],1会先出,这样一来，就颠倒了栈的出入顺序
	 */

	public MyQueue() {
		inputStack = new Stack<>();
		outputStack = new Stack<>();
	}

	// 进入队列
	public void push(int x) {
		inputStack.push(x);
	}

	/**
	 * 弹出队列的元素
	 * 
	 * @return
	 */
	public int pop() {
		if (outputStack.isEmpty()) {
			while (!inputStack.isEmpty()) {
				int element = inputStack.pop();
				outputStack.push(element);
			}
			return outputStack.pop();
		} else {
			return outputStack.pop();
		}
	}

	// 确认队列第一个元素
	public int peek() {

		if (outputStack.isEmpty()) {
			while (!inputStack.isEmpty()) {
				int element = inputStack.pop();
				outputStack.push(element);
			}
		}

		return outputStack.peek();
	}

	public boolean empty() {
		return inputStack.isEmpty() && outputStack.isEmpty();
	}
}
