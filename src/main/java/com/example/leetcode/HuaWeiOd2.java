package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 给定 str1 和 str2，如果 str1的字符串排列组合能在 str2 里面找到，则返回 str2 第一个匹配的字符的下标。如 str1 = “abc”，str2 = “qwcab” 返回 2；str1 = “abc”，str2 = “qcwab” 返回 -1。
输入：abc qwcab
输出：2
输入：abc qcwab
输出：-1

作者：芙·兰
链接：https://leetcode.cn/circle/discuss/Ppwg69/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * </pre>
 * 
 * @author liupan
 *
 */
public class HuaWeiOd2 {

	public static void main(String[] args) {
		String str1 = "abc";

		String str2 = "qwcab";

		System.out.println(includeStr(str1, str2));
	}

	private static int includeStr(String str1, String str2) {
		// 问题转化成求str1的排列组合。

		List<String> strs = buildStr(str1);

		System.out.println(strs);

		for (String s : strs) {
			if (str2.indexOf(s) > 0) {
				return str2.indexOf(s);
			}
		}
		return -1;
	}

	private static List<String> buildStr(String str1) {

		// 使用回溯
		// char[] chars = str1.toCharArray();

		List<String> result = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		//
		boolean[] used = new boolean[str1.length()];
		// 递归回溯
		// 需要有个数组记录使用情况
		addLetters(str1, result, sb, used);

		return result;
	}

	private static void addLetters(String str1, List<String> result, StringBuilder sb, boolean[] used) {

		if (sb.length() == str1.length()) {
			result.add(sb.toString());
			return;
		}

		for (int i = 0; i < str1.length(); i++) {
			if (used[i]) {
				continue;
			}
			sb.append(str1.charAt(i));
			used[i] = true;
			addLetters(str1, result, sb, used);
			// 回溯
			sb.deleteCharAt(sb.length() - 1);
			used[i] = false;
		}

	}
}
