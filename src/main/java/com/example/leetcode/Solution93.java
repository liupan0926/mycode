package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <pre>
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/restore-ip-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月22日 上午11:48:19
 *
 */
public class Solution93 {

	/**
	 * 输入：s = "101023"
	 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/restore-ip-addresses
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		LinkedList<String> path = new LinkedList<>();

		if (s.length() < 4 || s.length() > 12) {
			return res;
		}

		// 从索引0开始取,第一次取
		fetchNum(s, 0, 1, path, res);
		return res;
	}

	private void fetchNum(String s, int i, int count, LinkedList<String> path, List<String> res) {

		if (path.size() > 0 && !isCorrect(path.getLast())) {
			return;
		}

		// 取不到字符串
		if (i > s.length() - 1) {
			return;
		}

		// 取第四次时，剩下的就是一组，不用循环了
		if (count == 4) {
			String ip = s.substring(i);
			if (!isCorrect(ip)) {
				return;
			} else {
				path.add(ip);
				addRes(path, res);
				// 第四次加的也需要回退；
				path.removeLast();
				return;
			}
		}

		for (int x = 1; x <= 3 && x <= s.length() - 1 - i; x++) {
			int endIndex = i + x;
			String ip = s.substring(i, endIndex);
			path.add(ip);
			count = count + 1;
			fetchNum(s, endIndex, count, path, res);
			count = count - 1;
			path.removeLast();
		}
	}

	/**
	 * 从path里取出来，加个点，放到最终结果中
	 * 
	 * @param path
	 * @param res
	 */
	private void addRes(LinkedList<String> path, List<String> res) {
		StringBuilder sb = new StringBuilder();

		for (String s : path) {
			sb.append(s);
			sb.append(".");
		}

		String ip = sb.toString();
		// 去掉0
		res.add(ip.substring(0, ip.length() - 1));
	}

	/**
	 * 外面限制最多3位字符串，且都是数字
	 * 
	 * @param ip
	 * @return
	 */
	private boolean isCorrect(String ip) {
		// 0开头不行
		if (ip.length() > 1 && ip.startsWith("0")) {
			return false;
		}
		int num = Integer.parseInt(ip);
		if (num > 255) {
			return false;
		}

		return true;
		// 超过255也不行
	}

	public static void main(String[] args) {
//		String str = "1234.";
//		// 左闭右开
//		System.out.println(str.substring(0, str.length() - 1));
//		System.out.println(str.substring(4, 5));
		String str = "101023";
		Solution93 solution = new Solution93();
		System.out.println(solution.restoreIpAddresses(str));
	}
}
