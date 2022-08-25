package com.example.leetcode;

import java.util.Arrays;

/**
 * 
 * <pre>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。



来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月5日 上午11:33:09
 *
 */
public class Solution16 {

	public static void main(String[] args) {
		Solution16 sol = new Solution16();

		int[] nums = { -1, 2, 1, -4 };
		System.out.println(sol.threeSumClosest(nums, 1));
	}

	/**
	 * 输入：nums = [-1,2,1,-4], target = 1 输出：2 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
	 * 。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);

		int minSum = nums[0] + nums[1] + nums[2];
		int min = Math.abs(target - minSum);

		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int b = nums[left];
				int c = nums[right];
				int sum = a + b + c;

				int abs = Math.abs(target - sum);

				if (abs < min) {
					min = abs;
					minSum = sum;
					String str = String.format("sum:%d,a:%d,b:%d,c:%d", sum, a, b, c);
					System.out.println(str);
				}
				if (target == sum) {
					return target;
				} else if (target > sum) {
					left++;
				} else {
					right--;
				}
			}
		}

		return minSum;
	}

}
