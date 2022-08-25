package com.example.leetcode;

import com.example.sort.SortUtils;

public class SolutionTest1 {

	public static void main(String[] args) {
		int[] nums = { 2, 5, 3, 1, 4, 7, 6, 8 };

		SolutionTest1 sol = new SolutionTest1();

		sol.quickSort(nums);

		SortUtils.printfNums(nums);

	}

	public void quickSort(int[] nums) {

		int left = 0;

		int right = nums.length - 1;

		myQuickSort(left, right, nums);

	}

	private void myQuickSort(int start, int end, int[] nums) {

		int left = start;
		int right = end;
		int number = nums[left];

		// 2,5,3,1,4
		while (left < right) {

			while (nums[right] > number && left < right) {
				right--;
			}
			// 1,5,3,2,4
			nums[left] = nums[right];
			nums[right] = number;

			while (nums[left] < number && left < right) {
				left++;
			}
			nums[right] = nums[left];
			nums[left] = number;
		}
		if (start < left - 1) {
			myQuickSort(start, left - 1, nums);
		}
		if (left + 1 < end) {
			myQuickSort(left + 1, end, nums);
		}

	}

}
