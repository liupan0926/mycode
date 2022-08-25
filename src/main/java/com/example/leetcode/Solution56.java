package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * <pre>
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。

请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月21日 下午4:01:56
 *
 */
public class Solution56 {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		Solution56 sol = new Solution56();

		int[][] res = sol.merge(intervals);

		ArrayUtils.printArrays(res);
	}

	/**
	 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]] 输出：[[1,6],[8,10],[15,18]] 解释：区间
	 * [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/merge-intervals
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param intervals
	 * @return
	 */
	public int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		// intervals能够按照left值排序，要不会产生反复合并

		List<int[]> resList = new ArrayList<>();

		for (int i = 0; i < intervals.length; i++) {
			int[] arr = intervals[i];
			int start = arr[0];
			int end = arr[1];
			mergeNumber(resList, start, end);
		}

		return resList.toArray(new int[resList.size()][2]);
	}

	private void mergeNumber(List<int[]> resList, int start, int end) {

		// 代表只是初始化
		if (resList.size() == 0) {
			resList.add(new int[] { start, end });
		} else {
			boolean isMerge = false;
			for (int[] arr : resList) {
				// 分场景处理
				int right = arr[1];
				// 无法合并
				if (start > right) {
					continue;
				} else { // 其它场景都可以合并
					int max = Math.max(right, end);
					arr[1] = max;
					isMerge = true;
					break;
				}
			}
			if (!isMerge) {
				resList.add(new int[] { start, end });
			}
		}
	}
}
