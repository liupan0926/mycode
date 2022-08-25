package com.example.leetcode;

/**
 * 
 * <pre>
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给你一个整数，将其转为罗马数字。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/integer-to-roman
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月18日 上午11:52:07
 *
 */
public class Solution12 {

	public static void main(String[] args) {
		int num = 9;
		Solution12 sol = new Solution12();
		System.out.println(sol.intToRoman(num));
	}

	/**
	 * 
	 * <pre>
	 * 字符          数值
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	 * </pre>
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/integer-to-roman
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {

		int qian = num / 1000;

		num = num % 1000;

		StringBuilder sb = new StringBuilder();
		if (qian > 0) {
			dealQian(qian, sb);
		}

		int bai = num / 100;

		commonDeal(bai, sb, "bai");
		num = num % 100;

		int shi = num / 10;
		commonDeal(shi, sb, "shi");

		num = num % 10;

		commonDeal(num, sb, "ge");

		return sb.toString();

	}

	private void commonDeal(int bai, StringBuilder sb, String flag) {

		if (bai > 0) {
			if (bai <= 3) {
				while (bai > 0) {
					switch (flag) {
					case "bai":
						sb.append("C");
						break;
					case "shi":
						sb.append("X");
						break;
					case "ge":
						sb.append("I");
						break;
					default:
						break;
					}
					bai--;
				}
			} else if (bai == 4) {
				switch (flag) {
				case "bai":
					sb.append("CD");
					break;
				case "shi":
					sb.append("XL");
					break;
				case "ge":
					sb.append("IV");
					break;
				default:
					break;
				}
			} else { // bai>=5
				if (bai == 9) {
					switch (flag) {
					case "bai":
						sb.append("CM");
						break;
					case "shi":
						sb.append("XC");
						break;
					case "ge":
						sb.append("IX");
						break;
					default:
						break;
					}
				} else {
					switch (flag) {
					case "bai":
						sb.append("D");
						break;
					case "shi":
						sb.append("L");
						break;
					case "ge":
						sb.append("V");
						break;
					default:
						break;
					}
					bai = bai - 5;
					commonDeal(bai, sb, flag);
				}
			}
		}
	}

	private void dealQian(int qian, StringBuilder sb) {
		while (qian > 0) {
			sb.append("M");
			qian--;
		}
	}
}
