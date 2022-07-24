package com.example.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * <pre>
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月20日 下午12:22:37
 *
 */
public class Solution20 {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();

		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');

		Stack<Character> stack = new Stack<>();

		for (Character c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(map.get(c));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else if (!c.equals(stack.pop())) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
