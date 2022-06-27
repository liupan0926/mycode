package com.example.leetcode;

import com.example.sort.SortUtils;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 说明： 你的算法应该具有线性时间复杂度。
 * 你可以不使用额外空间来实现吗？ 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 类Solution136.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 27, 2022 4:34:49 PM
 */
public class Solution136 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4, 1, 5, 5, 1, 4, 2, 6, 7, 8, 7, 6, 8 };
        System.out.println(singleNumber(nums));
    }

    /**
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        //1.快排方式
        //        quicksort(nums);
        //        SortUtils.printfNums(nums);
        //        for (int i = 0; i < nums.length; i = i + 2) {
        //            if (nums[i] != nums[i + 1]) {
        //                return nums[i];
        //            }
        //        }

        //2.异或方式 , a ^^ a = 0; a^^b^^a= a^^a^^b; 0^^b = b;
        int res = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }
        }
        return res;
    }

    private static void quicksort(int[] nums) {
        myQuickSort(0, nums.length - 1, nums);
    }

    private static void myQuickSort(int i, int j, int[] nums) {
        int baseNum = nums[i];

        int left = i;
        int right = j;

        while (left < right) {
            //从右到左找到比基准小的数
            while (left < right && nums[right] >= baseNum) {
                right--;
            }
            //交换位置 
            nums[left] = nums[right];
            while (left < right && nums[left] < baseNum) {
                left++;
            }
            //刚刚right的位置 赋值
            nums[right] = nums[left];
        }
        //当left=right时，循环终止
        nums[left] = baseNum;

        if (left > i) {
            myQuickSort(i, left - 1, nums);
        }
        if (left + 1 < j) {
            myQuickSort(left + 1, j, nums);
        }
    }

}
