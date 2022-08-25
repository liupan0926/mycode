package com.example.leetcode;

/**
 * 
 * <pre>
整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月7日 上午11:05:12
 *
 */
public class Solution33 {

	public static void main(String[] args) {
		Solution33 sol = new Solution33();

		int[] nums = { 6, 7, 0, 1, 2, 4, 5 };

		System.out.println(sol.search(nums, 0));
	}

	/**
	 * 输入：nums = [4,5,6,7,0,1,2], target = 0 输出：4
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {

		// 特殊的二分查找
		int left = 0;
		int right = nums.length - 1;

		if (target > nums[right] && target < nums[left]) {
			return -1;
		}

		while (left <= right) {
			int mid = left + (right - left) / 2;

			int midNum = nums[mid];
			if (midNum == target) {
				return mid;
			}

			// 一定有一边是有序的
			boolean isRightOrder = false;
			// 右边有序
			if (midNum <= nums[right]) {
				isRightOrder = true;
			}

			if (isRightOrder) {
				// 去左边找
				if (midNum > target) {
					right = mid - 1;
				} else {
					// 去左边
					if (target > nums[right]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				}
			}
			// 6,7,0,1,2,4,5 寻找0
			// 左边是有序的
			else {
				if (midNum > target) {
					// 左边找
					if (target >= nums[left]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				} else {
					left = mid + 1;
				}
			}
		}

		return -1;

	}
}
