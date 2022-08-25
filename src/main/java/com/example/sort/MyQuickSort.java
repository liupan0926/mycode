package com.example.sort;

/**
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月9日 下午7:51:42
 *
 */
public class MyQuickSort {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 5, 1, 4, 10, 9, 7, 6, 8 };

		MyQuickSort sol = new MyQuickSort();
		sol.myQuickSort(nums);

		SortUtils.printfNums(nums);
	}

	public void myQuickSort(int[] nums) {

		// 2,3,5,1,4

		int left = 0;
		int right = nums.length - 1;

		quickSort(left, right, nums);
	}

	private void quickSort(int start, int end, int[] nums) {
		int number = nums[start];

		int left = start;
		int right = end;

		// 双指针
		while (left < right) {
			while (nums[right] >= number && right > left) {
				right--;
			}
			// 1,3,5,2,4
			nums[left] = nums[right];
			nums[right] = number;

			while (nums[left] <= number && left < right) {
				left++;
			}
			// 1,2,5,3,4
			nums[right] = nums[left];
			nums[left] = number;
		}
		// 最后left 和 right 一定是一样的
		if (start < left - 1) {
			quickSort(start, left - 1, nums);
		}
		if (left + 1 < end) {
			quickSort(left + 1, end, nums);
		}

	}
}
