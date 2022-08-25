package com.example.leetcode;

import com.example.sort.SortUtils;

/**
 * 
 * <pre>
整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。

例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。

必须 原地 修改，只允许使用额外常数空间。



来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月12日 上午11:08:55
 *
 */
public class Solution31 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2 };

		Solution31 sol = new Solution31();

		sol.nextPermutation(nums);
		SortUtils.printfNums(nums);
	}

	/**
	 * 示例 1：
	 * 
	 * 输入：nums = [1,2,3] 输出：[1,3,2] 示例 2：
	 * 
	 * 输入：nums = [3,2,1] 输出：[1,2,3] 示例 3：
	 * 
	 * 输入：nums = [1,1,5] 输出：[1,5,1]
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/next-permutation
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {

		int right = nums.length - 1;

		boolean isFind = false;

		while (right - 1 >= 0) {
			// 右边的比左边的大，就存在结果
			// 1，3，2，1
			if (nums[right] > nums[right - 1]) {
				// 找到1比3小，存在结果
				// 先将1右边的数 从小到大排序，变成 1，1，2，3

				// right-1 即是1的索引
				int left = right - 1;
				reverseNum(right, nums);
				// 再 从左到右找到 第一个比1大的数字 2，交换位置
				swap(left, nums);
				// 2,1,1,3
				// 这里就找到结果了
				isFind = true;
				break;
			} else {
				right--;
			}
		}

		// 如果最终没有找到，那就是 4，3，2，1这种了
		// 直接倒转变成1，2，3，4即可
		if (!isFind) {
			reverseNum(0, nums);
		}

	}

	private void swap(int left, int[] nums) {
		for (int i = left + 1; i < nums.length; i++) {
			// 找到第一个比它大的
			if (nums[i] > nums[left]) {
				int temp = nums[left];
				nums[left] = nums[i];
				nums[i] = temp;
				break;
			}
		}

	}

	/**
	 * 从right 到 nums.lengh-1 是一个倒序的 ，要变成从小到大顺序
	 * 
	 * @param right
	 * @param nums
	 */
	private void reverseNum(int start, int[] nums) {
		int end = nums.length - 1;
		if (start == end) {
			return;
		}

		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}

	}
}
