package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <pre>
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月22日 下午3:54:38
 *
 */
public class Solution78 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		Solution78 sol = new Solution78();
		System.out.println(sol.subsets(nums));
	}

	/**
	 * 输入：nums = [1,2,3] 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {

		LinkedList<Integer> path = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();

		// 空的也算子集
		res.add(new ArrayList<>(path));
		int start = 0;
		fetchNum(nums, start, path, res);

		return res;
	}

	private void fetchNum(int[] nums, int start, LinkedList<Integer> path, List<List<Integer>> res) {

		if (path.size() > 0) {
			res.add(new ArrayList<>(path));
		}

		// 索引超过
		if (start >= nums.length) {
			return;
		}

		for (int i = start; i < nums.length; i++) {
			path.add(nums[i]);
			fetchNum(nums, i + 1, path, res);
			path.removeLast();
		}
	}

}
