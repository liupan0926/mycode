package com.example.sort;

/**
 * 选择排序 类SelectSort.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 20, 2022 7:54:04 PM
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 1, 5, 2 };
        selectSort(nums);

        SortUtils.printfNums(nums);
    }

    public static void selectSort(int[] nums) {
        long start = System.currentTimeMillis();

        //n个元素找到最小值，然后n-1个元素再找到最小值
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = min;
            nums[minIndex] = temp;
        }

        Long cost = System.currentTimeMillis() - start;
        System.out.println("快速排序耗时:" + cost);
    }
}
