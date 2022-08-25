package com.example.leetcode;

/**
 * 
 * <pre>
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月18日 下午4:13:20
 *
 */
public class Solution72 {

	public static void main(String[] args) {
		Solution72 sol = new Solution72();

		String word1 = "horse";
		String word2 = "ros";

		System.out.println(sol.minDistance(word1, word2));

	}

	/**
	 * 输入：word1 = "horse", word2 = "ros" 输出：3 解释： horse -> rorse (将 'h' 替换为 'r')
	 * rorse -> rose (删除 'r') rose -> ros (删除 'e')
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/edit-distance
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {

		/**
		 * A[0,i-1] B[0,j-1] 需要K步 相等，则AB相等 需要 (k,k+1)步，看a[i] == b[j];
		 * 
		 * A[0,i] B[0,j-1] K步，则 A[0,i] B[0,j] 需要A加一个字符,k+1步
		 * 
		 * A[0,i-1] B[0,j] K步，则 A[0,i] B[0,j] 需要A减一个字符,k+1步
		 */

		// 定义dp数组，dp[i][j] 表达的含义是 A的0-i个字符 和 B的0-j个字符的最小编辑距离
		// 因为有取0个字符，所以 i 都代表A 的第i个字符，从1开始， dp[0][0]代表都不取字符。

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			for (int j = 0; j <= word2.length(); j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 0;
				} else if (i == 0) {
					// word2 j个字符，需要j步
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					// 情况1
					// A B 分别加一个字符

					int min1;
					// 第i个字符，索引-1
					if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
						min1 = dp[i - 1][j - 1];
					} else {
						min1 = dp[i - 1][j - 1] + 1;
					}

					// 情况2
					int min2;
					// A加一个字符
					min2 = dp[i][j - 1] + 1;
					// A减一个字符
					int min3;
					min3 = dp[i - 1][j] + 1;

					dp[i][j] = Math.min(Math.min(min1, min2), min3);
					// 相当于二维数组0行0列都已经初始化以后，需要填满整个数组，dp[1,1] 的 值 依赖 dp[0,0],dp[1,0],dp[0,1]就可以决定
				}
				//System.out.println("i:" + i + ",j:" + j + ",dpij:" + dp[i][j]);
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
