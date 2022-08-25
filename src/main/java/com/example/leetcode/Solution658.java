package com.example.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * <pre>
给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。

整数 a 比整数 b 更接近 x 需要满足：

|a - x| < |b - x| 或者
|a - x| == |b - x| 且 a < b

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-k-closest-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月25日 下午12:12:35
 *
 */
public class Solution658 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 6, 7 };
		Solution658 sol = new Solution658();

		int k = 3;
		int x = 4;
		List<Integer> res = sol.findClosestElements(arr, k, x);
		System.out.println(res);
	}

	/**
	 * 输入：arr = [1,2,3,4,5], k = 4, x = -1 输出：[1,2,3,4]
	 * 
	 * 输入：arr = [1,2,3,4,5], k = 4, x = 3 输出：[1,2,3,4]
	 * 
	 * @param arr
	 * @param k
	 * @param x
	 * @return
	 */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		List<Integer> res = new ArrayList<>();
		// 删掉两边n-k个节点即可
		int cnt = arr.length - k;
		int left = 0;
		int right = arr.length - 1;
		for (int i = 0; i < cnt; i++) {
			if (Math.abs(x - arr[left]) <= Math.abs(arr[right] - x)) {
				right--;
			} else {
				left++;
			}
		}
		for (int i = left; i <= right; i++) {
			res.add(arr[i]);
		}
		return res;
	}

}
