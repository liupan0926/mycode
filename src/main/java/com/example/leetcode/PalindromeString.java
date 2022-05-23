package com.example.leetcode;

/**
 * 最长回文子串
 * 
 * <pre>
 *   输入：s = "babad"
 *   输出："bab"
 *   解释："aba" 同样是符合题意的答案。
 * </pre>
 * 
 * @author liupan May 23, 2022 11:50:56 AM
 */
public class PalindromeString {

    public static void main(String[] args) {
        String str = "abcb";

        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        int maxLength = 0;
        String result = "";

        StringBuilder sb = new StringBuilder();
        char[] strChars = s.toCharArray();

        //去头去尾,这种是处理 奇数个回文的
        for (int i = 0; i < strChars.length; i++) {
            int offset = 0;
            //确认是奇数 还是 偶数 回文

            int j = i;
            while (j < strChars.length) {
                if (strChars[i] == strChars[j]) {
                    j++;
                } else {
                    break;
                }
            }
            j = j - 1;
            offset = findOffset(strChars, i, j);

            //证明存在回文
            if (offset >= 0 || i != j) {
                sb = new StringBuilder();
                for (int m = i - offset; m <= j + offset; m++) {
                    sb.append(strChars[m]);
                }

                if (sb.length() > maxLength) {
                    result = sb.toString();
                    maxLength = result.length();
                }
            }
        }

        return result;

    }

    private static int findOffset(char[] strChars, int i, int j) {
        int offset;
        //abad
        for (offset = 0; offset < strChars.length; offset++) {
            //到达了边缘，跳出循环
            if (i - offset < 0 || j + offset >= strChars.length) {
                break;
            }
            //符合要求
            else if (strChars[i - offset] == strChars[j + offset]) {
                continue;
            }
            //不符合要求
            else {
                break;
            }
        }
        //由于加了1后不符合要求，得回退
        offset = offset - 1;
        return offset;
    }

}
