package com.example.leetcode;

/**
 * 
 * <pre>
 * 函数 myAtoi(string s) 的算法如下：

读入字符串并丢弃无用的前导空格
检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
返回整数作为最终结果。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/string-to-integer-atoi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月25日 下午12:12:38
 *
 */
public class Solution8 {

	public static void main(String[] args) {
		String str = "-91283472332";

		System.out.println(myAtoi(str));
	}

	public static int myAtoi(String s) {
		// 1.处理前导空格
		// 2.处理正号负号
		// 3.处理数字
		// 4.到达末尾 or 到达非数字字符
		// 5.判断数字是否在int范围内

		StringBuilder sb = new StringBuilder();

		boolean isFuShu = false;
		boolean isStartNumber = false;

		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 前导空格忽略
			if (c == ' ' && !isStartNumber) {
				continue;
			} else if ((c == '+' || c == '-') && !isStartNumber) {
				if (c == '-') {
					isFuShu = true;
				}
				isStartNumber = true;
			} else if (isNumber(c)) {
				isStartNumber = true;
				sb.append(c);
			} else {
				// 非数字字符
				break;
			}
		}

		if (sb.toString().length() > 0) {
			res = getNumberFromStr(sb.toString(), isFuShu);
		}
		return res;
	}

	/**
	 * '00102' = 102
	 * 
	 * @param string
	 * @return
	 */
	private static int getNumberFromStr(String string, boolean isFushu) {
		StringBuilder sb = new StringBuilder();
		boolean isBegin = true;

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '0' && isBegin) {
				continue;
			} else {
				sb.append(c);
				isBegin = false;
			}
		}
		long res = 0L;
		int num = 0;
		if (sb.toString().length() > 0) {
			// 这里也会存在溢出
			// 最多40亿，int最大值
			if (sb.toString().length() > 10) {
				// 兼容负数场景
				if (isFushu) {
					num = Integer.MIN_VALUE;
				} else {
					num = Integer.MAX_VALUE;
				}
			} else {
				res = Long.parseLong(sb.toString());
				if (isFushu) {
					res = res * (-1);
				}

				if (res <= Integer.MIN_VALUE) {
					num = Integer.MIN_VALUE;
				} else if (res >= Integer.MAX_VALUE) {
					num = Integer.MAX_VALUE;
				} else {
					num = (int) res;
				}
			}

		}
		return num;
	}

	private static boolean isNumber(char c) {
		int index = c - '0';
		if (index >= 0 && index <= 9) {
			return true;
		}
		return false;
	}

}
