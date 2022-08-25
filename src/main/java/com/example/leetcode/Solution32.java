package com.example.leetcode;

/**
 * 
 * <pre>
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
https://leetcode.cn/problems/longest-valid-parentheses/
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月16日 下午12:56:35
 *
 */
public class Solution32 {

	public static void main(String[] args) {
		String s = "()()))))()()(";

		Solution32 sol = new Solution32();

		System.out.println(sol.longestValidParentheses(s));

	}

	/**
	 * 输入：s = "(()" 输出：2 解释：最长有效括号子串是 "()"
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {

		if (s.length() == 0) {
			return 0;
		}

		// 表达以 i字符结尾的最长字串长度
		int[] dp = new int[s.length()];

		int max = 0;

		dp[0] = 0;
		// ()()))))()()(

		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				dp[i] = 0;
			} else {
				// (())
				// i=3时，dp[2]=2;
				// 找到左边的那个字符
				int pre = i - dp[i - 1] - 1;
				if (pre >= 0 && s.charAt(pre) == '(') {
					dp[i] = dp[i - 1] + 2;
					// ()(()) 存在这种情况，pre左边还有连续的字串
					if (pre >= 1) {
						dp[i] += dp[pre - 1];
					}
				}

				max = Math.max(max, dp[i]);
			}
			System.out.println(dp[i]);
		}

		return max;

	}

}
