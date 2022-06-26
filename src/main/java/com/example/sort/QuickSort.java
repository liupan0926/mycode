package com.example.sort;

import java.util.Arrays;

/**
 * 快速排序 通过一趟排序将无序序列分为独立的两个序列，第一个序列的值均比第二个序列的值小。然后递归地排列两个子序列，以达到整个序列有序
 * 
 * @author liupan Jun 20, 2022 3:55:28 PM
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4, 1, 5, 5, 6, 2, 1, 4, 5, 6 };
        quickSort(nums);

    }

    public static void quickSort(int[] numss) {
        int[] nums = Arrays.copyOf(numss, numss.length);
        long start = System.currentTimeMillis();
        // 3,2,4,1,5
        // 以3位基准，
        // 第一次, 1,2,4,3,5; 3跟1换位置
        //第二次, 2,2,1,3,5; 5跟3换，5在3右边。，3的位置就好了，左右递归即可。
        myQuickSort(0, nums.length - 1, nums);
        Long cost = System.currentTimeMillis() - start;
        System.out.println("快速排序耗时:" + cost);
        SortUtils.printfNums(nums);
    }

    private static void myQuickSort(int left, int right, int[] nums) {
        int baseNum = nums[left];

        int first = left;
        int last = right;

        while (first < last) {
            while (first < last && nums[last] >= baseNum) {
                last--;
            }
            nums[first] = nums[last];
            while (first < last && nums[first] <= baseNum) {
                first++;
            }
            //刚刚right那个位置赋值
            nums[last] = nums[first];
        }
        nums[first] = baseNum;

        //SortUtils.printfNums(nums);

        if (first > left) {
            myQuickSort(left, first, nums);
        }
        if (first + 1 < right) {
            myQuickSort(first + 1, right, nums);
        }

    }

}
