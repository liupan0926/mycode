package com.example.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * @author liupan
 *
 */
public class Solution70 {

	public static void main(String[] args) {
		int n = 4;

		System.out.println(climbStairs(n));
	}

	/**
	 * <pre>
	 * 输入：n = 3
	输出：3
	解释：有三种方法可以爬到楼顶。
	1. 1 阶 + 1 阶 + 1 阶
	2. 1 阶 + 2 阶
	3. 2 阶 + 1 阶
	 * 
	 * 
	 * 
	 * </pre>
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {

		int[] fn = new int[n + 1];

		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		// 代表为n时的方法种数；
		fn[1] = 1;
		fn[2] = 2;

		for (int i = 3; i <= n; i++) {
			// 当为n时，fn[n-1] 的次数 + 单独1个 ，以及 和fn[n-1]里最后单独的1，组合为2，

			// f3 = f2+1; f2 有个单独的1
			// f4 = f3+2; f3 有两个单独的1，可以跟新来的1组合成2，多的就是这两种
			// f5 = f4+3;

			// fn = f(n-1)+ n-2
			fn[i] = fn[i - 1] + fn[i - 2];
		}

		int res = fn[n];
		return res;
	}
}
