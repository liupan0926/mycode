package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <pre>
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月12日 下午12:03:15
 *
 */
public class Solution46 {

	List<List<Integer>> res = new ArrayList<>();

	LinkedList<Integer> path = new LinkedList<>();

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		Solution46 sol = new Solution46();

		System.out.println(sol.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		int[] usedNum = new int[nums.length];
		fetchNum(nums, usedNum);
		return res;
	}

	private void fetchNum(int[] nums, int[] usedNum) {

		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (usedNum[i] == 0) {
				path.add(nums[i]);
				usedNum[i] = 1;
				fetchNum(nums, usedNum);
				path.removeLast();
				usedNum[i] = 0;
			}
		}

	}
}
