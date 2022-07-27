package com.example.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 
 * @author liupan Jun 23, 2022 4:25:33 PM
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4, 1, 5, 5, 6, 2, 1, 4, 5, 6 };
        mergeSort(nums);
        SortUtils.printfNums(nums);
    }

    public static void mergeSort(int[] numss) {
        int[] nums = Arrays.copyOf(numss, numss.length);
        long start = System.currentTimeMillis();
        sort(0, nums.length - 1, nums);
        Long cost = System.currentTimeMillis() - start;
        System.out.println("归并排序耗时:" + cost);
    }

    private static void sort(int i, int j, int[] nums) {
        //最终细分到只有一个元素的数组
        if (i == j) {
            return;
        }
        int length = j - i + 1;
        int middle = i + length / 2;
        //左边序列排序
        sort(i, middle - 1, nums);
        //右边序列排序
        sort(middle, j, nums);
        merge(nums, i, j, middle);
    }

    private static void merge(int[] nums, int i, int j, int middle) {

        int[] temp = new int[j - i + 1];

        int left = i;
        int right = middle;

        int index = 0;
        while (left < middle && right <= j) {
            if (nums[left] <= nums[right]) {
                temp[index] = nums[left];
                left++;
            } else {
                temp[index] = nums[right];
                right++;
            }
            index++;
        }
        //跳出就是某个指针到头了
        while (left < middle) {
            temp[index] = nums[left];
            index++;
            left++;
        }
        while (right <= j) {
            temp[index] = nums[right];
            index++;
            right++;
        }

        //填回nums
        for (int x = 0; x < temp.length; x++) {
            nums[i + x] = temp[x];
        }
    }

}
