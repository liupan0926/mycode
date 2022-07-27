package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
只使用数字1到9
每个数字 最多使用一次 
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/combination-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月11日 下午8:11:13
 *
 */
public class Solution216 {

	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 9));
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		if (n > 45) {
			return res;
		}
		chooseNum(1, 9, n, k, res, list);
		return res;
	}

	private static void chooseNum(int start, int end, int n, int k, List<List<Integer>> res, List<Integer> list) {

		// 剪枝
		// 1.和超过了
		// 2.个数不够了
		if (n < 0 || k < 0) {
			return;
		}
		if (k == 0 && n > 0) {
			return;
		}

		if (n == 0 && k == 0) {
			res.add(new ArrayList<>(list));
		}

		for (int i = start; i <= end; i++) {
			list.add(i);
			chooseNum(i + 1, end, n - i, k - 1, res, list);
			list.remove(Integer.valueOf(i));
		}
	}
}
