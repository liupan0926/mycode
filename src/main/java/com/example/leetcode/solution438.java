package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author liupan
 *
 */
public class solution438 {

	public static void main(String[] args) {
		String s = "cbaebabacd";

		String p = "abc";
		
		
		System.out.println(findAnagrams(s,p));
	}

	/**
	 * 
	 * <pre>
	 * 输入: s = "abab", p = "ab"
	输出: [0,1,2]
	解释:
	起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
	起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
	起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
	
	来源：力扣（LeetCode）
	链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * </pre>
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> resultList = new ArrayList<>();
		// 滑动窗口
		// 所谓异位，就是同一窗口内，字母数量一致

		// 26个字母计数
		int[] sCount = new int[26];
		int[] pCount = new int[26];
		for (int i = 0; i < p.length(); i++) {
			pCount[p.charAt(i) - 'a']++;
			sCount[s.charAt(i) - 'a']++;
		}
		if (Arrays.equals(sCount, pCount)) {
			resultList.add(0);
		}

		int len = p.length();
		for (int i = 0; i < s.length()-len; i++) {
			--sCount[s.charAt(i) - 'a'];
			++sCount[s.charAt(i + len) - 'a'];
			if (Arrays.equals(sCount, pCount)) {
				resultList.add(i + 1);
			}
		}
		return resultList;
	}
}
