package com.example.leetcode;

/**
 * 
 * <pre>
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
如果可以，返回 true ；否则返回 false 。
magazine 中的每个字符只能在 ransomNote 中使用一次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/ransom-note
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月19日 上午11:42:32
 *
 */
public class Solution383 {

	/**
	 * 
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct(String ransomNote, String magazine) {

		int[] arrs = new int[26];

		for (char c : magazine.toCharArray()) {
			int index = c - 'a';
			arrs[index]++;
		}

		for (char c : ransomNote.toCharArray()) {
			int index = c - 'a';
			arrs[index]--;

			if (arrs[index] < 0) {
				return false;
			}
		}

		return true;
	}
}
