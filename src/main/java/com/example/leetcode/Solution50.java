package com.example.leetcode;

import java.math.BigDecimal;

/**
 * 
 * <pre>
实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * 
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月20日 下午4:40:42
 *
 */
public class Solution50 {
	/**
	 * 
	 * 示例 1：
	 * 
	 * 输入：x = 2.00000, n = 10 输出：1024.00000 示例 2：
	 * 
	 * 输入：x = 2.10000, n = 3 输出：9.26100 示例 3：
	 * 
	 * 输入：x = 2.00000, n = -2 输出：0.25000 解释：2-2 = 1/22 = 1/4 = 0.25
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/powx-n
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {

		double res = 1.0;

		if (x == 1.00000) {
			return x;
		}

		int pow = n;
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				// 偶数
				pow = Integer.MAX_VALUE - 1;
			} else {
				pow = Math.abs(n);
			}
		}

		while (pow != 0) {
			if (pow % 2 != 0) {
				res = res * x;
			}
			x = x * x;
			pow = pow / 2;
		}

		return n >= 0 ? res : 1 / res;
	}

	public static void main(String[] args) {
		double x = 2.10000;
		Solution50 sol = new Solution50();

		double res = sol.myPow(x, 3);

		System.out.println(res);
	}
}
