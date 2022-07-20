package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * @author liupan
 *
 */
public class Solution77 {

	public static void main(String[] args) {
		System.out.println(combine(5, 2));
	}

	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();

		List<Integer> list = new ArrayList<>();
		addNum(list, 1, n, k, res);

		return res;
	}

	private static void addNum(List<Integer> list, int start, int end, int k, List<List<Integer>> res) {

		// 怎么剪枝？
		// 1-4 里找5个数
		if (end - start + 1 < k) {
			return;
		}

		if (k == 0) {
			res.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= end; i++) {
			list.add(i);
			addNum(list, i + 1, end, k - 1, res);
			list.remove(Integer.valueOf(i));
		}
	}
}
