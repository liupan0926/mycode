package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 
 * 1 <= nums.length <= 5 * 105
    -231 <= nums[i] <= 231 - 1
 * </pre>
 * 
 * 类FirstMissingPositive.java的实现描述：TODO 类实现描述
 * 
 * @author liupan May 29, 2022 12:16:37 PM
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = { -5 };
        //int[] nums = { 3, 4, -1, 1 };

        System.out.println(firstMissingPositive(nums));
    }

    /**
     * <pre>
     * 思路：
     * 
     * 先循环一遍数组，last[index] = 0 or 1,index代表》>=0的整数，0 or 1 代表是否出现过
     * 找到最小的 index以后，
     * 如果index=0 or 1,则index++，找到第一个数组值为0的；
     * 如果index >1,则最小值为 index-1;
     * </pre>
     * 
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }

            if (min == -1) {
                min = nums[i];
            } else {
                min = Math.min(min, nums[i]);
            }
        }
        if (min == -1) {
            min = 1;
        } else if (min > 1) {
            result = 1;
        } else {
            //min = 0 or 1时
            while (map.get(min) != null) {
                min++;
            }
            result = min;
        }
        return result;

    }
}
