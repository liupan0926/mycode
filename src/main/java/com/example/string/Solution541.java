package com.example.string;

/**
 * 
 * <pre>
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/reverse-string-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月21日 下午12:43:44
 *
 */
public class Solution541 {

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;

		System.out.println(reverseStr(s, k));
	}

	/**
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public static String reverseStr(String s, int k) {
		int len = s.length();

		char[] str = s.toCharArray();

		for (int i = 0; i < s.length(); i = i + 2 * k) {
			int from = i;
			// 索引
			int end = i + 2 * k - 1;
			// 字符足够
			if (len >= (2 * k + i)) {// 翻转k个
				reverse(from, from + k - 1, str);
			} else if (len < 2 * k + i && len >= i + k) {
				reverse(from, from + k - 1, str);
			} else { // len <i+k
				reverse(from, len - 1, str);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : str) {
			sb.append(c);
		}

		return sb.toString();
	}

	private static void reverse(int i, int j, char[] s) {

		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}
}
