package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <pre>
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月12日 下午12:23:35
 *
 */
public class Solution131 {

	public static void main(String[] args) {
		String str = "a";
		System.out.println(partition(str));
	}

	/**
	 * 输入：s = "aab" 输出：[["a","a","b"],["aa","b"]]
	 * 
	 * @param s
	 * @return
	 */
	public static List<List<String>> partition(String s) {

		LinkedList<String> path = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		// 同组合问题，切割字符串也是回溯
		qiege(0, s, path, res);
		return res;
	}

	private static void qiege(int startIndex, String s, LinkedList<String> path, List<List<String>> res) {

		if (path.size() > 0) {
			String lastStr = path.getLast();

			// 判断是否回文字符串
			if (!isRerverse(lastStr)) {
				return;
			}
		}

		if (startIndex > s.length() - 1) {
			res.add(new ArrayList<>(path));
			return;
		}

		// 代表一次取第0个字符，i=1时，代表取0，1两个字符
		for (int i = 1; i <= s.length() - startIndex; i++) {
			// 从startIndex开始切割
			path.add(s.substring(startIndex, startIndex + i));
			qiege(startIndex + i, s, path, res);
			path.removeLast();
		}

	}

	private static boolean isRerverse(String lastStr) {
		// "aa","aba" 回文字符串
		for (int i = 0, j = lastStr.length() - 1; i < j; i++, j--) {
			if (lastStr.charAt(i) != lastStr.charAt(j)) {
				return false;
			}
		}
		return true;
	}

//	public static void main(String[] args) {
//		String str = "aab";
//
//		System.out.println(str.substring(2, 3));
//	}
}
