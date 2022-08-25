package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <pre>
给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。

如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。



来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月24日 上午10:30:45
 *
 */
public class Solution1460 {
	public boolean canBeEqual(int[] target, int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < target.length; i++) {
			map.put(target[i], map.getOrDefault(target[i], 0) + 1);
		}

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				return false;
			} else {
				int count = map.get(arr[i]);
				count = count - 1;
				if (count == 0) {
					map.remove(arr[i]);
				} else {
					map.put(arr[i], count);
				}
			}
		}

		return map.size() == 0;
	}
}
