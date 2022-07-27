package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * @author liupan
 *
 */
public class Solution22 {

	/**
	 * <pre>
	 * 输入：n = 3
	   输出：["((()))","(()())","(())()","()(())","()()()"]
	   
	   输入：n = 1
	   输出：["()"]
	 * 
	 * </pre>
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {

		// 使用动态规划处理.

		// 代表为n时的结果。

		List<String>[] fn = new List[n];

		List<String> f1 = new ArrayList<>();

		f1.add("()");

		fn[1] = f1;

		return fn[n];

	}

}
