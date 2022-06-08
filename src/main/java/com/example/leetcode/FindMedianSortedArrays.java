package com.example.leetcode;

import java.math.BigDecimal;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 算法的时间复杂度应该为
 * O(log (m+n)) 。 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 类FindMedianSortedArrays.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 6, 2022 12:23:27 PM
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;

        int length = nums1.length + nums2.length;
        int num[] = new int[length];

        int i = 0, j = 0;
        int c = 0;

        while (i < nums1.length || j < nums2.length) {
            int minNum = 0;
            if (i == nums1.length) {
                minNum = nums2[j];
                j++;
            } else if (j == nums2.length) {
                minNum = nums1[i];
                i++;
            }
            else if (nums1[i] <= nums2[j]) {
                minNum = nums1[i];
                i++;
            } else {
                minNum = nums2[j];
                j++;
            }

            num[c] = minNum;
            c++;
        }

        //奇数
        if (length % 2 == 1) {
            res = num[length / 2];
        } else {
            int temp = length / 2;
            int sum = (num[temp - 1] + num[temp]);
            BigDecimal dd = new BigDecimal(sum);
            BigDecimal rr = dd.divide(new BigDecimal(2));
            res = rr.doubleValue();
        }

        return res;
    }

}
