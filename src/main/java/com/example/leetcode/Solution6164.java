package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <pre>
给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。

请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月17日 下午3:43:26
 *
 */
public class Solution6164 {
	/**
	 * 输入：nums = [18,43,36,13,7] 输出：54 解释：满足条件的数对 (i, j) 为： - (0, 2) ，两个数字的数位和都是 9
	 * ，相加得到 18 + 36 = 54 。 - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。 所以可以获得的最大和是
	 * 54 。
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param nums
	 * @return
	 */
	public int maximumSum(int[] nums) {
		int max = -1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int he = calNum(nums[i]);
			if (map.containsKey(he)) {
				// 把值大的放进map
				int mapIndex = map.get(he);
				int temp = nums[i] + nums[mapIndex];
				max = Math.max(max, temp);
				if (nums[i] > nums[mapIndex]) {
					map.put(he, i);
				}
			} else {
				map.put(he, i);
			}
		}
		return max;
	}

	/**
	 * input:18 return 9;
	 * 
	 * @param i
	 * @return
	 */
	private int calNum(int i) {
		int res = 0;
		while (i > 0) {
			res += i % 10;
			i = i / 10;
		}
		return res;
	}
}
