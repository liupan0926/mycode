package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 * 
 * 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] =
 * 3 ，则第 1 个人必须位于大小为 3 的组中。
 * 
 * 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
 * 
 * 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月13日 下午5:01:34
 *
 */
public class Solution1282 {

	public static void main(String[] args) {
		int[] groupSizes = {3,3,3,3,3,1,3 };

		Solution1282 sol = new Solution1282();

		System.out.println(sol.groupThePeople(groupSizes));
	}

	/**
	 * 输入：groupSizes = [3,3,3,3,3,1,3] 输出：[[5],[0,1,2],[3,4,6]] 解释： 第一组是 [5]，大小为
	 * 1，groupSizes[5] = 1。 第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] =
	 * groupSizes[2] = 3。 第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] =
	 * groupSizes[6] = 3。 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param groupSizes
	 * @return
	 */
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> res = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < groupSizes.length; i++) {
			int number = groupSizes[i];
			List<Integer> p1 = null;
			if (map.containsKey(number)) {
				p1 = map.get(number);
				p1.add(i);
			} else {
				p1 = new ArrayList<>(number);
				p1.add(i);
			}

			// 如果已经满了，
			if (p1.size() == number) {
				// 加入答案里面
				res.add(p1);
				if (map.containsKey(number)) {
					// 清空给下一个3使用
					map.remove(number);
				}
			} else {
				map.put(number, p1);
			}
		}
		return res;
	}
}
