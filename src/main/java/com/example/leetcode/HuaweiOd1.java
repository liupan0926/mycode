package com.example.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * <pre>
 * 给定两个数组arr1和arr2,其中arr2中元素互不相同，无重复。且arr2中出现的元素在arr1中都存在。
	要求对arr1进行重新排序，满足以下几点要求：
	arr2中出现过的元素保持相对位置不变；
	arr2中未出现过的元素放到arr1末尾，且采用升序排列。
	给出的用例如下：
	arr1=[2,5,6,7,3,19,4,2,5,9]
	arr2=[2,3,5,7,6]
	期望输出：
	[2,2,3,5,5,7,6,4,9,19]

作者：tanjingui
链接：https://leetcode.cn/circle/discuss/xpxp92/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * </pre>
 * 
 * @author liupan
 *
 */
public class HuaweiOd1 {

	public static void main(String[] args) {
		int[] arr1 = { 2, 5, 6, 7, 3, 19, 4, 2, 5, 9 };

		int[] arr2 = { 2, 3, 5, 7, 6 };

		Integer[] res = convert(arr1, arr2);

		for (Integer i : res) {
			System.out.println(i);
		}
	}

	private static Integer[] convert(int[] arr1, int[] arr2) {

		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < arr2.length; i++) {
			// 初始化为0次
			map.put(arr2[i], 0);
		}

		for (int i = 0; i < arr1.length; i++) {
			Integer key = arr1[i];
			if (map.containsKey(key)) {
				Integer value = map.get(key) + 1;
				map.put(key, value);
			} else {
				map.put(key, 1);
			}
		}

		// 遍历 map输出结果
		ArrayList<Integer> list = new ArrayList<>(arr1.length);
		ArrayList<Integer> list2 = new ArrayList<>();

		int startIndex = 0;
		// 是否需要排序
		boolean isSort = false;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (startIndex == arr2.length) {
				// 后面的需要开始排序了
				isSort = true;
			}
			if (!isSort) {
				addKeyToArray(list, entry);
				startIndex++;
			} else {
				addKeyToArray(list2, entry);
			}
		}
		Collections.sort(list2);
		//list2.sort(Integer::compareTo);
		list.addAll(list2);
		Integer[] res = new Integer[arr1.length];
		return list.toArray(res);
	}

	private static void addKeyToArray(ArrayList<Integer> list, Entry<Integer, Integer> entry) {
		for (int j = 0; j < entry.getValue(); j++) {
			list.add(entry.getKey());
		}
	}
}
