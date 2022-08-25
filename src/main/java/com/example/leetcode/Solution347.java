package com.example.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.example.sort.SortUtils;

/**
 * 
 * <pre>
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
 * 
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月20日 上午10:06:43
 *
 */
public class Solution347 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3, 3, 3, 4 };

		Solution347 sol = new Solution347();

		SortUtils.printfNums(sol.topKFrequent(nums, 3));
	}

	public int[] topKFrequent(int[] nums, int k) {

		// 数组，下标为nums里的数字，值为数字的count

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				Integer c = map.get(nums[i]);
				c++;
				map.put(nums[i], c);
			} else {
				map.put(nums[i], 1);
			}
		}

		// 队列，最小的在前面,
		PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 次数小的在前面
				return o1[1] - o2[1];
			}
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int[] myNumber = new int[2];
			myNumber[0] = entry.getKey();
			myNumber[1] = entry.getValue();

			if (pQueue.size() < k) {
				pQueue.add(myNumber);
			} else {
				// 比它小
				if (myNumber[1] <= pQueue.peek()[1]) {

				} else {
					pQueue.poll();
					pQueue.add(myNumber);
				}
			}
		}

		int[] res = new int[k];

		for (int i = 0; i < res.length; i++) {
			res[i] = pQueue.poll()[0];
		}

		return res;

	}
}
