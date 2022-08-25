package com.example.leetcode;

import com.example.sort.SortUtils;

/**
 * 
 * <pre>
给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

必须在不使用库的sort函数的情况下解决这个问题。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月13日 下午3:55:38
 *
 */
public class Solution75 {

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };

		Solution75 sol = new Solution75();

		sol.sortColors(nums);

		SortUtils.printfNums(nums);
	}

	/**
	 * 输入：nums = [2,0,2,1,1,0] 输出：[0,0,1,1,2,2]
	 * 
	 * @param nums
	 */
	public void sortColors(int[] nums) {

		// 0 的范围 [0,zero];
		// 1 (zero,two);
		// 2 的范围 [two,length-1];
		int zero = 0;
		int two = nums.length;
		int i = 0;
		while (i < two) {
			if (nums[i] == 0) {
				swap(i, zero, nums);
				zero++;
				i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				two--;
				swap(i, two, nums);
			}
		}
	}

	private void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
