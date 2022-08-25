package com.example.leetcode;

/**
 * 
 * <pre>
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标。
https://leetcode.cn/problems/jump-game/
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月17日 上午10:12:09
 *
 */
public class Solution55 {

	public static void main(String[] args) {
		int[] nums = { 2,3,1,1,4 };
		Solution55 sol = new Solution55();

		System.out.println(sol.canJump(nums));
	}

	/**
	 * 
	 * 输入：nums = [2,3,1,1,4] 输出：true 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3
	 * 步到达最后一个下标。
	 * 
	 * 
	 * 输入：nums = [3,2,1,0,4] 输出：false 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ，
	 * 所以永远不可能到达最后一个下标。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/jump-game
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {

		// 使用贪心算法

		// 记录可以跳到的最远坐标；
		int maxJump = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i <= maxJump) {
				maxJump = Math.max(maxJump, i + nums[i]);
			}

			if (maxJump >= nums.length - 1) {
				return true;
			}
		}
		return false;

//		// 动态规划算法太慢了
//		// 使用dp来处理
//		// dp[i] 代表第i个坐标是否能到达,
//		boolean[] dp = new boolean[nums.length];
//
//		dp[0] = true;
//
//		for (int i = 1; i < nums.length; i++) {
//			for (int j = i - 1; j >= 0; j--) {
//
//				// 如果能到达j,且j的步数足够到达i
//				if (dp[j]) {
//					int num = j + nums[j];
//					if (num >= i) {
//						dp[i] = true;
//						break;
//					}
//				}
//			}
//			System.out.println(dp[i]);
//		}
//
//		return dp[nums.length - 1];

	}
}
