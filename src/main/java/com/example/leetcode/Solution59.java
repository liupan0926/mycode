package com.example.leetcode;

/**
 * 
 * <pre>
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月18日 上午10:31:53
 *
 */
public class Solution59 {

	public static void main(String[] args) {
		int n = 5;

		int[][] res = generateMatrix(n);

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.println(res[i][j]);
			}
		}

	}

	public static int[][] generateMatrix(int n) {
		// 左闭右开
		// n=2，循环一次,每边1个数字
		// n=3，也是循环一次，每边2个数字。然后中心点一个数字
		// n=4,循环两次，第一次循环，每边3个数字，第二次循环，每边1个数字
		int[][] res = new int[n][n];

		// 奇数的话，中心有个数字
		// 循环次数
		int loop = n / 2;
		// 当前值的下一个
		int curNext = 1;

		int numberN = n;

		// 第几次循环
		int nLoop = 0;
		while (n >= 1) {
			if (n == 1) {
				res[loop][loop] = curNext;
				break;
			}
			// 每边的数字
			int num = n - 1;

			int top = curNext;
			// 上面
			for (int i = 0; i < num; i++) {
				// 值从1开始
				res[0 + nLoop][i + nLoop] = i + top;
				curNext = i + 1 + top;
			}
			// 右边
			int right = curNext;
			for (int j = 0; j < num; j++) {
				res[nLoop + j][numberN - 1 - nLoop] = right + j;
				curNext = right + j + 1;
			}
			// 下边
			int bottom = curNext;
			for (int x = num; x > 0; x--) {
				res[numberN - 1 - nLoop][x + nLoop] = bottom + (num - x);
				curNext = bottom + (num - x) + 1;
			}
			// 左边
			int left = curNext;
			for (int y = num; y > 0; y--) {
				res[nLoop + y][0 + nLoop] = left + (num - y);
				curNext = left + (num - y) + 1;
			}
			// 循环一遍完了,4的话就是2
			n = n - 2;
			nLoop = nLoop + 1;
		}

		return res;

	}
}
