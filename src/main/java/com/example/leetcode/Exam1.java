package com.example.leetcode;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			String str = in.next();
			System.out.println(convert(str));
		}

	}

	/**
	 * 一次转换找到最小字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String convert(String str) {
		String res = str;
		// ecdb -> 最高位开始，从右边找到一个比它小的交换，如果没有比它小的，就找第二位
		Character minChar = null;
		int minIndex = -1;
		for (int i = 0; i < str.length(); i++) {
			char left = str.charAt(i);
			for (int j = str.length() - 1; j > i; j--) {
				char right = str.charAt(j);
				// 有比它小的
				if (isCompare(right, left)) {
					if (minChar == null) {
						minChar = right;
						minIndex = j;
					}
					// 找到最小的
					else if (isCompare(right, minChar)) {
						minChar = right;
						minIndex = j;
					}
				}
			}

			if (minChar != null) {
				res = swap(i, minIndex, str);
				break;
			} else {
				// 没有的化i+1
				continue;
			}

		}
		return res;
	}

	private static String swap(int i, int minIndex, String str) {
		char a = str.charAt(i);
		char b = str.charAt(minIndex);

		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < str.length(); j++) {
			if (j == i) {
				sb.append(b);
			} else if (j == minIndex) {
				sb.append(a);
			} else {
				sb.append(str.charAt(j));
			}
		}
		return sb.toString();
	}

	/**
	 * x是否小于y
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isCompare(char x, char y) {
		int left = x - 'a';
		int right = y - 'a';

		return left < right;
	}
}
