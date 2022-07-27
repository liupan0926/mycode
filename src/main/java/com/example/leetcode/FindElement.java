package com.example.leetcode;

/**
 * <pre>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 如果数组中不存在目标值
 * target，返回 [-1, -1]。 进阶： 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan Jun 10, 2022 11:29:22 AM
 */
public class FindElement {

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 9, 9, 10 };

        System.out.println(findTarget(nums, 8)[0] + "_" + findTarget(nums, 8)[1]);

    }

    public static int[] findTarget(int[] nums, int target) {
        int[] res = { -1, -1 };

        //二方查找

        int length = nums.length;

        int min = findLeft(target, nums, 0, length - 1);

        int max = findRight(target, nums, 0, length - 1);

        res[0] = min;
        res[1] = max;
        return res;
    }

    private static int findRight(int target, int[] nums, int i, int j) {
        int res = -1;
        if (target < nums[i] || target > nums[j]) {
            return res;
        }

        while (i <= j) {
            int len = j - i + 1;
            int middle = i + (len / 2);
            if (nums[middle] == target) {
                if (res == -1) {
                    res = middle;
                } else {
                    res = Math.max(middle, res);
                }
                i = middle + 1;
            } else if (nums[middle] < target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return res;

    }

    private static int findLeft(int target, int[] nums, int i, int j) {
        int res = -1;
        if (target < nums[i] || target > nums[j]) {
            return res;
        }

        while (i <= j) {
            int len = j - i + 1;
            int middle = i + (len / 2);
            if (nums[middle] == target) {
                if (res == -1) {
                    res = middle;
                } else {
                    res = Math.min(middle, res);
                }
                j = middle - 1;
            } else if (nums[middle] < target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return res;

    }

}
