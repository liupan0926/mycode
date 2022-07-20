package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <pre>
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明： 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。

示例 1: 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]

示例 2: 输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [   [1,2,2],   [5] ]

#
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月18日 下午3:52:15
 *
 */
public class Solution40 {

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;

		System.out.println(combinationSum2(candidates, target));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>();
		// 变成从小到大的顺序，方便剪枝
		Arrays.sort(candidates);
		int sum = 0;
		fetchNum(candidates, target, sum, 0, path, res);
		return res;
	}

	private static void fetchNum(int[] candidates, int target, int sum, int from, LinkedList<Integer> path,
			List<List<Integer>> res) {

		if (sum == target) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = from; i < candidates.length && sum + candidates[i] <= target; i++) {
			// 去重的逻辑
			if (i > from && candidates[i] == candidates[i - 1]) {
				continue;
			}
			path.add(candidates[i]);
			// usedArray[i] = 1;
			sum = sum + candidates[i];
			fetchNum(candidates, target, sum, i + 1, path, res);
			sum = sum - candidates[i];
			path.removeLast();
		}
	}
}
