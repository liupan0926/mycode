package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月8日 上午11:28:31
 *
 */
public class Solution45 {

	public static void main(String[] args) {

		Solution45 sol = new Solution45();
		int[] nums = { 2, 1, 1, 4, 1 };
		System.out.println(sol.jump(nums));
	}

	/**
	 * 使用贪心算法再实现一下，dp太耗时
	 * 
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		// 使用贪心算法

		// 走的步数
		int steps = 0;

		// 当前坐标能达到的最大范围
		int curMax = 0;

		// 能到达的最远距离
		int end = 0;
		// 2,1,1,4,1
		for (int i = 0; i < nums.length; i++) {
			curMax = Math.max(curMax, i + nums[i]);
			if (curMax >= nums.length - 1) {
				// 假如第一次就到了，也得要1步
				steps = steps + 1;
				break;
			}
			if (end == i) {
				// 到了当前坐标后，+1步才能跳的更远
				steps++;
				end = curMax;
			}
		}
		return steps;
	}

//	/**
//	 * 输入: nums = [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。   从下标为 0 跳到下标为 1
//	 * 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//	 * 
//	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/jump-game-ii
//	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//	 * 
//	 * @param nums
//	 * @return
//	 */
//	public int jump(int[] nums) {
//
//		// 到达索引为n的节点的最小步数
//		int[] dp = new int[nums.length];
//
//		dp[0] = 0;
//		// 如果第一个节点步数为0，那这个题就无解
//		dp[1] = 1;
//
//		for (int i = 2; i < nums.length; i++) {
//
//			// 到达索引i的 所有可能，
//			// 前一个节点不为0，就可以，总步数+1
//			// 或者直接从第一个节点就能到
//			int j = i - 1;
//
//			List<Integer> indexList = new ArrayList<>();
//			while (j >= 0) {
//				// 代表j这个节点可以到达i
//				if (nums[j] >= (i - j)) {
//					indexList.add(j);
//				}
//				j--;
//			}
//			// 到达前面那个节点+1,前面的dp都初始化过了
//
//			dp[i] = getMinPath(indexList, dp) + 1;
//		}
//
//		return dp[nums.length - 1];
//	}
//
//	private int getMinPath(List<Integer> indexList, int[] dp) {
//		int min = dp[indexList.get(0)];
//
//		for (Integer i : indexList) {
//			if (dp[i] < min) {
//				min = dp[i];
//			}
//		}
//		return min;
//	}
}
