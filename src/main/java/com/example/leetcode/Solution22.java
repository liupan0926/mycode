package com.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

	public static void main(String[] args) {

		Solution22 sol = new Solution22();

		System.out.println(sol.generateParenthesis(4));
	}

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
		List<String>[] fn = new List[n + 1];

		List<String> f1 = new ArrayList<>();

		f1.add("()");

		fn[0] = new ArrayList<>();
		fn[1] = f1;

		/**
		 * fn 和 f(n-1)的差距，主要 是第n个括号在 f(n-1)的内部或者外部
		 * 
		 * (f(n-1)) or () f(n-1)，当然f(n-1)的括号构成是这样的,
		 * 
		 * 左边的括号（）p个，右边的括号 q个，然后 p+q = n-1;
		 */

		for (int i = 2; i <= n; i++) {
			List<String> fi = new ArrayList<>();

			// ( fp ) + fq, p+q = n-1;p=0时，相当于都在括号外部，p=n-1时，相当于都在括号内部

			for (int p = 0; p <= i - 1; p++) {
				int q = i - 1 - p;

				List<String> fp = fn[p];
				List<String> fq = fn[q];

				if (fp.size() > 0) {

					for (String strP : fp) {
						StringBuilder sb = new StringBuilder();
						sb.append("(");
						sb.append(strP);
						sb.append(")");
						for (String strQ : fq) {
							sb.append(strQ);
						}
						fi.add(sb.toString());
					}
				} else {
					for (String strQ : fq) {
						StringBuilder sb = new StringBuilder();
						sb.append("(");
						sb.append(")");
						sb.append(strQ);
						fi.add(sb.toString());
					}
				}
			}

			Collections.sort(fi);

			fn[i] = fi;

		}

		return fn[n];

	}

}
