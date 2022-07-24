package com.example.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
根据 逆波兰表示法，求表达式的值。

有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

注意 两个整数之间的除法只保留整数部分。

可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月20日 下午4:02:57
 *
 */
public class Solution150 {

	public static void main(String[] args) {
		String[] tokens = { "10","6","9","3","+","-11","*","/","*","17","+","5","+" };

		System.out.println(evalRPN(tokens));
	}

	/**
	 * 
	 * <pre>
	 * 输入：tokens = ["2","1","+","3","*"] 输出：9 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
	 * 
	 * tokens = ["2","1","+","3","*"] 输入：tokens =
	 * ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] 输出：22
	 * 
	 * </pre>
	 * 
	 * @param tokens
	 * @return
	 */
	public static int evalRPN(String[] tokens) {

		List<String> fuhao = new ArrayList<>();
		fuhao.add("+");
		fuhao.add("-");
		fuhao.add("*");
		fuhao.add("/");

		ArrayDeque<String> stack = new ArrayDeque<>();

		int sum = 0;

		// 左边操作数
		int num1 = 0;
		int num2 = 0;
		for (String x : tokens) {
			if (fuhao.contains(x)) {
				num2 = Integer.parseInt(stack.pop());
				num1 = Integer.parseInt(stack.pop());
				int temp = getCal(num1, num2, x);
				stack.push(Integer.toString(temp));
			} else {
				stack.push(x);
			}
		}

		sum = Integer.parseInt(stack.pop());
		return sum;
	}

	private static int getCal(int num1, int num2, String x) {
		int res = 0;
		if ("+".equals(x)) {
			res = num1 + num2;
		}
		if ("-".equals(x)) {
			res = num1 - num2;
		}
		if ("*".equals(x)) {
			res = num1 * num2;
		}
		if ("/".equals(x)) {
			res = num1 / num2;
		}
		return res;
	}
}
