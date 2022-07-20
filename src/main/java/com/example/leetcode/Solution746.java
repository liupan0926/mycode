package com.example.leetcode;

/**
 * 
 * <pre>
给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

请你计算并返回达到楼梯顶部的最低花费。

输入：cost = [1,100,1,1,1,100,1,1,100,1]
输出：6
解释：你将从下标为 0 的台阶开始。
- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
总花费为 6 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/min-cost-climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月12日 下午3:48:47
 *
 */
public class Solution746 {

	public static void main(String[] args) {

		// int[] cost = { 10, 15, 20 };
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

		System.out.println(minCostClimbingStairs(cost));
	}

	public static int minCostClimbingStairs(int[] cost) {
		// 动态规划
		// 从0还是从1，比较0跟1的费用，爬1还是爬2，比较2跟3的费用

		// 为到达i层的最小费用,假如提供3级台阶,[0,1,2]，则需要爬到3 ，
		// 从0层到length+1的最小费用

		if (cost.length == 1) {
			return cost[0];
		}

		int[] dp = new int[cost.length];

		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int n = 2; n < cost.length; n++) {
			// 到达n台阶的最小费用
			dp[n] = Math.min(dp[n - 1], dp[n - 2]) + cost[n];
		}
		
		
		int res = Math.min(dp[cost.length - 1], dp[cost.length - 2]);

		return res;
	}
}
