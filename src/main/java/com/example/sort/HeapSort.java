package com.example.sort;

/**
 * 堆排序https://www.runoob.com/w3cnote/heap-sort.html
 * 
 * @author liupan Jun 23, 2022 3:34:10 PM
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 6, 5, 7, 2, 1 };
		heapSort(nums);
		SortUtils.printfNums(nums);
	}

	/**
	 * 
	 * @param nums
	 */
	public static void heapSort(int[] nums) {

		// 【5，4，3，1，2】
		// 第一个非叶子节点 的索引
		int i = nums.length / 2 - 1;
		// 构造大顶堆

		for (int index = i; index >= 0; index--) {
			buildMaxHeap(nums, index, nums.length);
			SortUtils.printfNums(nums);
		}

		// 大顶堆构建完成以后，开始交换，

		int maxIndex = nums.length - 1;
		int len = nums.length;

		while (maxIndex > 0) {
			swap(0, maxIndex, nums);
			maxIndex--;
			// 最后的索引已经固定了,不需要排序
			len--;
			buildMaxHeap(nums, 0, len);
		}

	}

	private static void buildMaxHeap(int[] nums, int index, int len) {

		// 从下至上构建大顶堆。
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;

		int largeIndex = index;
		if (leftIndex < len && nums[leftIndex] > nums[largeIndex]) {
			largeIndex = leftIndex;
		}

		if (rightIndex < len && nums[rightIndex] > nums[largeIndex]) {
			largeIndex = rightIndex;
		}

		if (largeIndex != index) {
			swap(largeIndex, index, nums);
			// 换下来的largeIndex的子树，也得变成大顶堆
			buildMaxHeap(nums, largeIndex, len);
		}

	}

	private static void swap(int largeIndex, int index, int[] nums) {
		int temp = nums[index];
		nums[index] = nums[largeIndex];
		nums[largeIndex] = temp;
	}

}
