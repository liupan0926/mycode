package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * <pre>
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-consecutive-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月12日 下午3:24:22
 *
 */
public class Soloution128 {

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2, 6 };

		Soloution128 sol = new Soloution128();

		System.out.println(sol.longestConsecutive(nums));
	}

	/**
	 * 输入：nums = [100,4,200,1,3,2] 输出：4 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
	 * 
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int maxLong = 0;
		for (int i = 0; i < nums.length; i++) {
			int left = nums[i] - 1;
			int right = nums[i] + 1;

			if (set.contains(right)) {
				continue;
			} else {
				while (set.contains(left)) {
					left--;
				}
			}

			// 4到1 长度就是4，0是没有的 4-0
			maxLong = Math.max(maxLong, nums[i] - left);
		}

		return maxLong;
	}
}
