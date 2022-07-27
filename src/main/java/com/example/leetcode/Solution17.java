package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 给出数字到字母的映射如下（与电话按键相同）。注意 1
 * 不对应任何字母。 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 
 * @author liupan Jun 7, 2022 4:15:16 PM
 */
public class Solution17 {

    public static void main(String[] args) {

        String digits = "23";

        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();
        String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        //记录每次的值
        StringBuilder temp = new StringBuilder();

        //digits左边的第0位
        int num = 0;
        addLetters(digits, letters, num, temp, result);

        return result;

    }

    private static void addLetters(String digits, String[] letters, int num, StringBuilder temp, List<String> result) {
        //递归结束的条件

        if (num == digits.length()) {
            result.add(temp.toString());
            return;
        }

        String letter = letters[digits.charAt(num) - '0'];

        for (int i = 0; i < letter.length(); i++) {
            temp.append(letter.charAt(i));
            //temp  = a, 加了一个字母d以后 ，输出ad,需要删掉d,才能再输出ae
            addLetters(digits, letters, num + 1, temp, result);
            //删除temp的最后一个字母
            temp.deleteCharAt(num);
        }

    }

}
