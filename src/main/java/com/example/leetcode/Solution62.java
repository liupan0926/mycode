package com.example.leetcode;

/**
 * 
 * <pre>
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月12日 下午4:22:02
 *
 */
public class Solution62 {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
	}

	public static int uniquePaths(int m, int n) {

		// 例子时3行2列

		// 记录到达这个坐标的路径条数
		int[][] dp = new int[m][n];

		dp[0][0] = 1;
		// 处理这个数组，最终答案就是 dp[m-1][n-1];
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {

				if (x == 0 && y >= 1) {
					dp[x][y] = dp[x][y - 1];
				}

				if (y == 0 && x >= 1) {
					dp[x][y] = dp[x - 1][y];
				}

				if (x >= 1 && y >= 1) {
					dp[x][y] = dp[x][y - 1] + dp[x - 1][y];
				}
			}
		}

		print(dp);

		return dp[m - 1][n - 1];
	}

	private static void print(int[][] dp) {
		int m = dp.length;
		int n = dp[0].length;

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				System.out.println("x:" + x + ",y:" + y + "," + dp[x][y]);
			}
		}
	}
}
