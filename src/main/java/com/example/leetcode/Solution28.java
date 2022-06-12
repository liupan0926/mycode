package com.example.leetcode;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0
 * 开始）。如果不存在，则返回  -1 。 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 类Solution28.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 11, 2022 11:52:16 AM
 */
public class Solution28 {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "pi";

        System.out.println(strStr(haystack, needle));

    }

    public static int strStr(String haystack, String needle) {
        int startIndex = -1;
        boolean isNotEmpty = needle != null && !needle.isEmpty();
        if (!isNotEmpty) {
            return startIndex;
        }
        boolean isStart = false;
        int offset = 0;
        for (int i = 0; i < haystack.length(); i++) {
            char h = haystack.charAt((i));
            if (h == needle.charAt(offset)) {
                if (!isStart) {
                    isStart = true;
                    //临时记下，如果没finish,也是返回-1
                    startIndex = i;
                }
                //全部匹配完成
                if (offset == needle.length() - 1) {
                    return startIndex;
                } else {
                    offset++;
                }
            } else {
                //这里是在循环里面,当到达字符串末尾，长度不够时，也不符合条件
                if (isStart) {
                    isStart = false;
                    offset = 0;
                    //下一次匹配重新开始
                    //针对这种情况 "mississippi" "issip"
                    i = startIndex ;
                    startIndex = -1;
                }
            }
        }
        return -1;
    }
}
