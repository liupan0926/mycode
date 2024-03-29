package com.example.sort;

import java.util.Arrays;

/**
 * 
 * <pre>
 * 再手写一遍快排
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月24日 下午2:39:10
 *
 */
public class QuickSort1 {

	public static void main(String[] args) {
		int[] nums = { 5, 3, 4, 2, 1, 6, 8, 9 };

		quickSort(nums);

		SortUtils.printfNums(nums);
	}

	public static void quickSort(int[] numss) {
		// 5,3,4,2,1

		int[] nums = Arrays.copyOf(numss, numss.length);
		long start = System.currentTimeMillis();
		int left = 0;
		int right = nums.length - 1;
		quickSort(left, right, nums);
		Long cost = System.currentTimeMillis() - start;
		System.out.println("快速排序1耗时:" + cost);
		// SortUtils.printfNums(nums);
	}

	private static void quickSort(int start, int end, int[] nums) {

		int left = start;
		int right = end;
		int midIndex = left + (right - left + 1) / 2;
		int number = nums[midIndex];

		while (left < right) {
			while (nums[right] >= number && midIndex < right) {
				// 如果一直到midIndex,那就不移动
				right--;
			}
			// 交换 midIndex和right的位置
			swap(midIndex, right, nums);
			midIndex = right;
			// 开始处理left
			while (nums[left] <= number && left < midIndex) {
				left++;
			}
			swap(midIndex, left, nums);
			midIndex = left;
		}

		// SortUtils.printfNums(nums);

		if (midIndex < end - 1) {
			quickSort(midIndex + 1, end, nums);
		}

		if (midIndex > start + 1) {
			quickSort(start, midIndex - 1, nums);
		}

	}

	private static void swap(int midIndex, int right, int[] nums) {
		int temp = nums[midIndex];
		nums[midIndex] = nums[right];
		nums[right] = temp;
	}
}
