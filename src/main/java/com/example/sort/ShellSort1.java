package com.example.sort;

import java.util.Arrays;

/**
 * 
 * <pre>
 * 手写希尔排序
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月25日 上午10:25:31
 *
 */
public class ShellSort1 {

	public static void main(String[] args) {

		int[] nums = { 5, 4, 3, 1, 2 };
		shellSort(nums);

	}

	public static void shellSort(int[] numss) {
		int[] nums = Arrays.copyOf(numss, numss.length);
		long curStart = System.currentTimeMillis();
		// 选定步长
		int len = nums.length / 2;
		// 对各组进行插入排序
		while (len > 0) {
			for (int i = len; i < nums.length; i++) {
				// 对应步长的插入排序
				int start = i;
				while (start >= len && nums[start] < nums[start - len]) {
					swap(start, start - len, nums);
					start = start - len;
				}
			}
			len = len / 2;
		}
		Long cost = System.currentTimeMillis() - curStart;
		System.out.println("希尔排序1耗时:" + cost);
		//SortUtils.printfNums(nums);
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
