package com.example.leetcode;

/**
 * 
 * <pre>
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月17日 下午5:06:53
 *
 */
public class Solution27 {
	/**
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int i = 0;
		int j = nums.length - 1;

		while (i < j) {
			// 优先挪动末尾的指针
			if (nums[j] == val) {
				j--;
			}
			// 这里nums[j] 必然不是val
			if (nums[i] == val) {
				nums[i] = nums[j];
				nums[j] = val;
				j--;
			} else {
				i++;
			}
		}
		return j + 1;
	}
}
