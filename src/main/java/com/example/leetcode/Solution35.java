package com.example.leetcode;

public class Solution35 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };

        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 请必须使用时间复杂度为
     * O(log n) 的算法。 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        int res = -1;
        int i = 0, j = nums.length - 1;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        while (i <= j) {
            int len = j - i + 1;
            int middle = i + len / 2;

            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                i = middle + 1; //[middle+1,j]
            } else if (target < nums[middle]) {
                j = middle - 1;//[i,middle-1]
            }
        }
        res = j + 1;
        return res;
    }

}
