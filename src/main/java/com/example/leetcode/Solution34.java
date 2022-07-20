package com.example.leetcode;

/**
 * 
 * <pre>
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月14日 下午3:29:49
 *
 */
public class Solution34 {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6 };

		int[] res = searchRange(nums, 4);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}

	public static int[] searchRange(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		int[] res = { -1, -1 };

		int searchIndex = -1;
		while (left <= right) {
			int middle = left + (right - left + 1) / 2;
			if (nums[middle] == target) {
				// 找到了index
				searchIndex = middle;
				break;
			} else if (nums[middle] > target) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		if (searchIndex == -1) {
			return res;
		}
		//
		else {
			// 需要继续二分查找最小index和最大index
			int minIndex = searchIndex;
			// 查找最小时，是左闭右开的search，
			minIndex = searchLeft(nums, left, searchIndex, target);
			int maxIndex = searchIndex;

			maxIndex = searchRight(nums, searchIndex, right, target);

			res[0] = minIndex;
			res[1] = maxIndex;
		}

		return res;
	}

	private static int searchRight(int[] nums, int left, int right, int target) {
		int max = left;

		// 左开右闭
		while (left <= right) {
			int mid = left + (right - left + 1) / 2;
			int number = nums[mid];
			if (number == target) {
				max = mid;
				left = mid + 1;
			} else if (number > target) {
				right = mid - 1;
			}
		}

		return max;
	}

	private static int searchLeft(int[] nums, int left, int right, int target) {
		int minIndex = right;
		while (left <= right) {
			int mid = left + (right - left + 1) / 2;
			int number = nums[mid];
			if (number == target) {
				minIndex = mid;
				// 继续往左找
				right = mid - 1;
			} else if (number < target) {
				left = mid + 1;
			}
			// 没有大于的可能
			// 找到最小的index
		}
		return minIndex;
	}
}
