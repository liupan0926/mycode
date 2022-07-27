package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 类Solution20.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 28, 2022 10:00:04 AM
 */
public class Solution20 {

    public static void main(String[] args) {
        String s = "[]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            }

            else if (stack.size() == 0 || c != stack.pop()) {
                return false;
            }
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;

    }
}
