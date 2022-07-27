package com.example.leetcode;

/**
 * <pre>
 * 
 *  输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * </pre>
 * 
 * @author liupan May 24, 2022 2:56:09 PM
 */
public class LongestSubString {

    public static void main(String[] args) {
        String dd = "abba";

        System.out.println(lengthOfLongestSubstring(dd));
    }

    public static int lengthOfLongestSubstring(String str) {

        int result = 0;

        //记录某个字符出现的位置；
        int[] last = new int[128];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }

        int start = 0;

        //System.out.println(index);
        //char[] strArrays = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {

            int index = str.charAt(i);

            int weizhi = last[index];

            if (last[index] < 0) {
                //记录出现的位置
                last[index] = i;
                int tempLength = i - start + 1;
                if (tempLength > result) {
                    result = tempLength;
                }
            } else { //就是出现过对应字符了。
                int tempLength = Math.max(last[index] - start + 1, i - last[index]);
                if (tempLength > result) {
                    result = tempLength;
                }
                //记录子串，调整start的位置，继续处理
                //start 是数组的index
                start = last[index] + 1;
                last[index] = i;
            }
        }
        //上面解法 耗时太严重

        return result;
    }
}
