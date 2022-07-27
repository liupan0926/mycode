package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * <pre>
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 target 的不同组合数少于 150 个。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月11日 下午8:39:55
 *
 */
public class Solution39 {

	public static void main(String[] args) {
		int[] candidates = {2,7, 6, 3, 5, 1 };
		int target = 9;

	

		System.out.println(combinationSum(candidates, target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		fetchNum(0, 0, candidates, target, res, path);
		return res;
	}

	private static void fetchNum(int sum, int start, int[] candidates, int target, List<List<Integer>> res,
			List<Integer> path) {

		if (target == sum) {
			res.add(new ArrayList<>(path));
		}

		for (int i = start; i < candidates.length && target - candidates[i] >= sum; i++) {
			sum = sum + candidates[i];
			path.add(candidates[i]);
			fetchNum(sum, i, candidates, target, res, path);
			sum = sum - candidates[i];
			path.remove(Integer.valueOf(candidates[i]));
		}
	}

}
