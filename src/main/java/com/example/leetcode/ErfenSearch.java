package com.example.leetcode;

/**
 * 二分查找
 * 
 * <pre>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/binary-search
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * 类ErfenSearch.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 10, 2022 1:52:20 PM
 */
public class ErfenSearch {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int res = -1;
        while (i <= j) {
            if (target > nums[j] || target < nums[i]) {
                return res;
            }
            int len = j - i + 1;
            int middle = i + (len / 2);
            if (nums[middle] == target) {
                res = middle;
                break;
            } else if (nums[middle] < target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return res;
    }
}
