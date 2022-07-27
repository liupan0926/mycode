package com.example.sort;

/**
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月24日 下午3:50:00
 *
 */
public class MergeSort1 {

	public static void main(String[] args) {
		int[] nums = { 5, 4, 3, 2, 1, 7, 7, 2 };

		MergeSort1 sol = new MergeSort1();
		sol.mergeSort(nums);
	}

	public void mergeSort(int[] nums) {
		sort(0, nums.length - 1, nums);
	}

	private void sort(int start, int end, int[] nums) {

		if (start == end) {
			return;
		}

		int mid = start + (end - start + 1) / 2;
		// start = 0, end = 1,mid = 1;
		sort(start, mid - 1, nums);
		sort(mid, end, nums);
		merge(start, end, mid, nums);
		SortUtils.printfNums(nums);
	}

	private void merge(int start, int end, int mid, int[] nums) {
		int length = end - start + 1;
		int[] temp = new int[length];

		int i = start;
		int j = mid;

		int index = 0;
		while (i < mid || j <= end) {
			if (i >= mid) {
				temp[index] = nums[j];
				j++;
			} else if (j > end) {
				temp[index] = nums[i];
				i++;
			} else {
				if (nums[i] <= nums[j]) {
					temp[index] = nums[i];
					i++;
				} else {
					temp[index] = nums[j];
					j++;
				}
			}
			index++;
		}

		for (int x = 0; x < temp.length; x++) {
			nums[start + x] = temp[x];
		}
	}

}
