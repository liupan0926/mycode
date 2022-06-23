package com.example.sort;

/**
 * 插入排序
 * 
 * @author liupan Jun 21, 2022 11:29:20 AM
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4, 1, 5, 5, 6, 2, 1, 4, 5, 6 };
        insertSort(nums);
        SortUtils.printfNums(nums);
    }

    /**
     * 逆序变成顺序，9,8,7,6,5,4,3,2,1 ，排序次数 0+1+2+...+8 = (1+8)*8/2
     * ,o(n方),因为相等时是不移动的，稳定的排序
     * 
     * @param nums
     */
    public static void insertSort(int[] nums) {

        long start = System.currentTimeMillis();

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j >= 1 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                nums[j] = temp;
            }
        }
        Long cost = System.currentTimeMillis() - start;
        System.out.println("插入排序耗时:" + cost);
    }

}
