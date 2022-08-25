package com.example.leetcode;

/**
 * 
 * <pre>
给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月25日 上午11:13:50
 *
 */
public class Solution96 {

	public static void main(String[] args) {
		Solution96 sol = new Solution96();

		System.out.println(sol.numTrees(3));
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {

		// 没有dp[0]
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			// n=3时， 根节点为1和根节点为3的情况类似，2*dp[2]+ 2为根节点的情况。2,1,3只有1种

			// n=4时， 根节点为1和根节点为4的情况类似,2*dp[3]+ (2,3为根节点的情况)。 2跟3是对称的 2*dp[2]

			// n=5时，根节点为1和根节点为5的情况类似,2*dp[4]+(2,3,4为根节点的情况)。
			// 2跟4是对称的(2左边必为1，4右边必为5)，2*dp[3]
			// 根节点为3时,左右都是dp[2],一共dp[2]*dp[2]

			// 所以最终的公式为
			if (i == 3) {
				dp[i] = 2 * dp[2] + 1;
			} else {

//				dp[4] = 2 * dp[3] + 2 * dp[2];
//
//				dp[5] = 2 * dp[4] + 2 * dp[3] + dp[2] * dp[2];
//
//				dp[6] = 2 * dp[5] + 2 * dp[4] + 2 * dp[2] * dp[3];
//
//				dp[7] = 2 * dp[6] + 2 * dp[5] + 2 * dp[2] * dp[4] + dp[3] * dp[3];

				dp[i] = 2 * dp[i - 1] // 1和n为根节点的情况
						+ 2 * dp[i - 2]; // 2和n-1为根节点的情况
				for (int j = 2; j < i - 2; j++) {
					int temp = i - 1 - j;
					dp[i] += dp[j] * dp[temp];
				}
			}
		}
		return dp[n];
	}
}
