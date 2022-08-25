package com.example.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * <pre>
给你一个仅由数字（0 - 9）组成的字符串 num 。

请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。

注意：

你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
数字可以重新排序。


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/largest-palindromic-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月23日 下午4:52:34
 *
 */
public class Solution2384 {

	public static void main(String[] args) {
		String num = "444947137";
		Solution2384 sol = new Solution2384();

		System.out.println(sol.largestPalindromic(num));
	}

	public String largestPalindromic(String num) {
		// 回文数字特点是 偶数个在边上，奇数个在中间
		int[] number = new int[10];

		for (char c : num.toCharArray()) {
			int x = c - '0';
			number[x]++;
		}

		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();

		for (int j = number.length - 1; j >= 0; j--) {

			// 前导0
			if (j == 0 && sb.toString().length() == 0) {

			} else {
				int count = number[j] / 2;
				for (int i = 0; i < count; i++) {
					sb.append(j);
					stack.add(Integer.toString(j));
				}
				number[j] = number[j] - count * 2;
			}

		}

		for (int j = number.length - 1; j >= 0; j--) {
			if (number[j] > 0) {
				sb.append(j);
				break;
			}
		}
		// 中间那个数

		// 2个9，3个8，4个7

		// 98766866789

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}
}
