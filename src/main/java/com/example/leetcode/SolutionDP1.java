package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * <pre>
脉脉里的题目，正整数子集
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月27日 上午10:20:39
 *
 */
public class SolutionDP1 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 7, 8, 10, 20, 30, 40 };
		System.out.println(getChild(nums));
	}

	public static List<Integer> getChild(int[] nums) {

		/**
		 * 输入:[3,4,5,6,7];不重复的数字数组
		 * 
		 * 输出：求子集，[3,4,5,6],因为 7=3+4
		 */

		// 变成从小到大的数组
		Arrays.sort(nums);

		// 代表最终的结果
		// 二维数组的宽度代表子集的最长长度
		int[][] dp = new int[nums.length][nums.length];

		// dp[0] = 3

		// 第一行,其他列为0
		dp[0][0] = nums[0];

		Set<Integer> mySet = new HashSet<>();
		mySet.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			// 前面几列等于上一行的，第i列，需要判断
			for (int j = 0; j < i; j++) {
				dp[i][j] = dp[i - 1][j];
			}
			// 第一行第一列得逻辑判断是否要加入
			if (!isContains(i, nums, mySet)) {
				System.out.println(nums[i] + "_" + mySet);
				dp[i][i] = nums[i];
			}
		}

		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (dp[nums.length - 1][i] != 0) {
				res.add(dp[nums.length - 1][i]);
			}
		}
		return res;

	}

	private static boolean isContains(int i, int[] nums, Set<Integer> mySet) {
		int number = nums[i];
		// 如果包含，啥也不干
		if (mySet.contains(number)) {
			return true;
		}

		Integer[] temp = new Integer[mySet.size()];
		temp = (Integer[]) mySet.toArray(temp);

		for (Integer num : temp) {
			mySet.add(num + number);
		}

		mySet.add(number);
		return false;
	}

}
