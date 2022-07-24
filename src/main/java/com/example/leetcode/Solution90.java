package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <pre>
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月22日 下午4:23:19
 *
 */
public class Solution90 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		Solution90 sol = new Solution90();
		System.out.println(sol.subsetsWithDup(nums));
	}

	/**
	 * 输入：nums = [1,2,2] 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {

		LinkedList<Integer> path = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();

		res.add(new ArrayList<>());
		Arrays.sort(nums);
		// for循环的开始位置
		int start = 0;
		fetchNum(nums, start, path, res);

		return res;

	}

	/**
	 * [1,2,2]
	 * 
	 * @param nums
	 * @param start
	 * @param count
	 * @param path
	 * @param res
	 */
	private void fetchNum(int[] nums, int start, LinkedList<Integer> path, List<List<Integer>> res) {

		if (path.size() > 0) {
			res.add(new ArrayList<>(path));
		}

		if (start >= nums.length) {
			return;
		}

		for (int i = start; i < nums.length; i++) {
			// i=start ，可以输出【1，2，2】,以及[2,2];
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			path.add(nums[i]);
			fetchNum(nums, i + 1, path, res);
			path.removeLast();
		}
	}
}
