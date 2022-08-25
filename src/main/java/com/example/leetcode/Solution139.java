package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/word-break
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月13日 上午11:49:28
 *
 */
public class Solution139 {

	public static void main(String[] args) {
		String s = "catsandog";

		List<String> wordDict = new ArrayList<>();

//		wordDict.add("apple");
//		wordDict.add("pen");

//		wordDict.add("cats");
//		wordDict.add("dog");
//		wordDict.add("sand");
//		wordDict.add("and");
//		wordDict.add("cat");

		Solution139 sol = new Solution139();

		System.out.println(sol.wordBreak(s, wordDict));
	}

	/**
	 * 输入: s = "applepenapple", wordDict = ["apple", "pen"] 输出: true 解释: 返回 true 因为
	 * "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。   注意，你可以重复使用字典中的单词。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/word-break
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {

		boolean[] dp = new boolean[s.length() + 1];
		// 数组表达 dp[i] s的前i个字符是否能被字典覆盖，dp[j] 就是如果dp[i] = true,
		// 且[i,j]区间 字符能被字典覆盖，则d[j] = true;

		// 题目最终是要 dp[s.leng-1] 是否为true

		// 没啥意义，
		dp[0] = true;
		// 数组从1开始,字符串还是索引0
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == true && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}

		return dp[s.length()];

	}

//	public static void main(String[] args) {
//		String str = "applepenapple";
//
//		int i = 5;
//		String sstr = str.substring(1, 2);
//
//		System.out.println(sstr);
//	}

}
