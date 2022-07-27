//package com.example.leetcode;
//
//import java.util.Arrays;
//
///**
// * 
// * <pre>
//输入：nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
//输出：[2,2,1,0]
//解释：
//1. 裁剪到只剩 1 个数位后，nums = ["2","3","1","4"] 。最小的数字是 1 ，下标为 2 。
//2. 裁剪到剩 3 个数位后，nums 没有变化。第 2 小的数字是 251 ，下标为 2 。
//3. 裁剪到剩 2 个数位后，nums = ["02","73","51","14"] 。第 4 小的数字是 73 ，下标为 1 。
//4. 裁剪到剩 2 个数位后，最小数字是 2 ，下标为 0 。
//   注意，裁剪后数字 "02" 值为 2 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/query-kth-smallest-trimmed-number
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// * </pre>
// * 
// * @author liupan
// * @date 2022年7月17日 下午4:05:16
// *
// */
//public class Solution6121 {
//	public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
//
//		// 裁剪几次就是几个索引
//		int[] res = new int[queries.length];
//
//		// n行2列，第1列是最小数字,第2列是裁剪位数
//		for (int i = 0; i < queries.length; i++) {
//			// 裁剪位数
//			int trim = queries[i][1];
//			// 第几
//			int k = queries[i][0];
//			// 对应数字的下标
//			int tempIndex = caijian(nums, trim, k);
//			res[i] = tempIndex;
//		}
//		return res;
//	}
//
//	private int caijian(String[] nums, int trim, int k) {
//
//		int[] res = new int[nums.length];
//
//		for (int i = 0; i < nums.length; i++) {
//			// "123" 裁剪2位 = “23”；
//			int temp = Integer.parseInt(nums[i].substring(nums.length - k));
//			res[i] = temp;
//		}
//		Arrays.sort(
//		return res[k - 1];
//	}
//
//	public static void main(String[] args) {
//		String tem = "123";
//		System.out.println(tem.substring(1));
//	}
//}
