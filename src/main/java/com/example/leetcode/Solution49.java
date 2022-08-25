package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月20日 下午4:17:27
 *
 */
public class Solution49 {

	/**
	 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"] 输出:
	 * [["bat"],["nat","tan"],["ate","eat","tea"]]
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/group-anagrams
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> res = new ArrayList<>();

		// key 就是第一个单词
		Map<String, List<String>> hashMap = new HashMap<>();

		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);

			if (hashMap.containsKey(key)) {
				hashMap.get(key).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				hashMap.put(key, list);
			}
		}

		for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
			res.add(entry.getValue());
		}
		return res;

	}

}
