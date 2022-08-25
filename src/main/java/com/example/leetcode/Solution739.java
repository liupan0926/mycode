package com.example.leetcode;

import com.example.sort.SortUtils;

/**
 * 
 * <pre>
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月12日 下午3:48:20
 *
 */
public class Solution739 {

	public static void main(String[] args) {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		Solution739 sol = new Solution739();

		SortUtils.printfNums(sol.dailyTemperatures(temperatures));
	}

	/**
	 * 输入: temperatures = [73,74,75,71,69,72,76,73] 输出: [1,1,4,2,1,1,0,0]
	 * 
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperatures(int[] temperatures) {

		int[] res = new int[temperatures.length];

		// 从最后往前考虑，情况更简单

		for (int i = temperatures.length - 1; i >= 0; i--) {

			if (i == temperatures.length - 1) {
				res[i] = 0;
			} else {
				int j = i + 1;
				if (temperatures[i] < temperatures[j]) {
					res[i] = 1;
				} else {
					boolean isFind = false;
					while (j <= temperatures.length - 1) {
						if (temperatures[i] >= temperatures[j]) {
							// 如果还有更大的
							if (res[j] > 0) {
								j = j + res[j];
							} else {
								break;
							}
						} else {
							isFind = true;
							break;
						}
					}
					if (isFind) {
						res[i] = j - i;
					} else {
						res[i] = 0;
					}
				}
			}
		}

		return res;

	}

}
