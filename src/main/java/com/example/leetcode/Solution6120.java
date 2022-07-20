package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <pre>
给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：

从 nums 选出 两个 相等的 整数
从 nums 中移除这两个整数，形成一个 数对
请你在 nums 上多次执行此操作直到无法继续执行。

返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-number-of-pairs-in-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月17日 下午3:34:02
 *
 */
public class Solution6120 {
	public int[] numberOfPairs(int[] nums) {
		int[] res = new int[2];
		// 多少数对
		int resCount = 0;
		// map里剩下的数字 就是答案
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer number = nums[i];
			if (map.containsKey(number)) {
				map.remove(number);
				resCount++;
			} else {
				map.put(nums[i], i);
			}
		}
		int count = map.size();
		res[0] = resCount;
		res[1] = count;
		return res;
	}
}
