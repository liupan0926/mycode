package com.example.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。 类Solution14.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 17, 2022 6:44:44 PM
 */
public class Solution14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String temp = strs[0];

        while (temp.length() > 0) {
            boolean isAll = true;
            for (String s : strs) {
                if (!s.startsWith(temp)) {
                    temp = temp.substring(0, temp.length() - 1);
                    isAll = false;
                    break;
                } else {
                    continue;
                }
            }
            if (isAll) {
                return temp;
            }
        }
        return temp;

    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

}
