package com.example.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 子数组 是数组中的一个连续部分。
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月22日 下午4:27:34
 *
 */
public class Solution53 {

	public static void main(String[] args) {
		int[] nums = { 8, -19, 5, -4, 20 };

		Solution53 sol = new Solution53();

		System.out.println(sol.maxSubArray(nums));
	}

	/**
	 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4] 输出：6 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {

		// 以第i个数结尾的最大子集和
		int[] dp = new int[nums.length];

		dp[0] = nums[0];

		int res = dp[0];

		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
		}

		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > res) {
				res = dp[i];
				index = i;
			}
		}

		int cur = index;
		int sum = 0;
		while (cur >= 0) {
			sum = sum + nums[cur];
			if (sum != res) {
				cur--;
			} else {
				break;
			}
		}

		System.out.println("cur:" + cur + ",index:" + index);

		return res;
	}

}
