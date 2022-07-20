package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * <pre>
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月19日 上午10:36:59
 *
 */
public class Solution18 {

	public static void main(String[] args) {

		int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000 };

		int target = -294967296;

		List<List<Integer>> res = fourSum(nums, target);

		System.out.println(res);
	}

	/**
	 * 输入：nums = [1,0,-1,0,-2,2], target = 0 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();

		// -2,-1,0,0,1,2
		List<Integer> path = new ArrayList<>();
		if (nums[0] > target) {
			return res;
		}

		for (int i = 0; i <= nums.length - 4; i++) {
			int a = nums[i];
			// 去除重复
			if (i >= 1 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j <= nums.length - 3; j++) {
				int b = nums[j];
				// 去除重复
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					// 这里也需要去重
					if (left > j + 1 && nums[left] == nums[left - 1]) {
						left++;
						continue;
					}
					int c = nums[left];
					int d = nums[right];
					long sum = (long) a + (long) b + (long) c + (long) d;

					if (sum > Integer.MAX_VALUE) {
						right--;
					}
					if (sum == target) {
						path.add(a);
						path.add(b);
						path.add(c);
						path.add(d);
						res.add(new ArrayList<>(path));
						path.clear();
						left++;
					}
					// 右边缩小
					else if (sum > target) {
						right--;
					} else { // 左边扩大
						left++;
					}
				}
			}
		}
		return res;

	}

}
