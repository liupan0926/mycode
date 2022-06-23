package com.example.sort;

/**
 * 冒泡排序
 * 
 * @author liupan Jun 20, 2022 3:33:55 PM
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 1, 5, 2 };
        bubbleSort(nums);

    }

    /**
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        //-3,2,1,5,2
        //-2,1,3,2,5
        //-1,2,2,3,5

        //i 代表第几趟排序
        // 从 前 n-i+1 个元素 排序，i=1时，前n个元素;i=2时，前n-1个元素 
        long start = System.currentTimeMillis();
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                int a1 = nums[j];
                int a2 = nums[j + 1];
                if (a1 > a2) {
                    int temp = a2;
                    nums[j] = temp;
                    nums[j + 1] = a1;
                }
            }
        }
        Long cost = System.currentTimeMillis() - start;
        System.out.println("冒泡排序耗时:" + cost);

    }
}
