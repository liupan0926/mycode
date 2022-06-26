package com.example.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 
 * <pre>
 * 插入排序的升级版，
 * 1.序列具备一定顺序以后， 插入排序的比较和移动次数大大减少。
 * 2.步长很大时，组数较多，比较和移动次数较小；步长缩小时，每组数据变多，但是基本有序；
 * </pre>
 * 
 * @author liupan Jun 21, 2022 5:24:09 PM
 */
public class ShellSort {

    public static void shellSort(int[] numss) {

        int[] nums = Arrays.copyOf(numss, numss.length);

        long start = System.currentTimeMillis();
        int gap = nums.length;
        while (true) {
            //步长为长度的一半
            gap = gap / 2;

            //i为每一组的offset
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < nums.length; j = j + gap) {
                    //每组坐标的最新一个数
                    int k = j - gap;
                    //分组插入排序
                    while (k >= 0 && nums[k] > nums[k + gap]) {
                        int temp = nums[k];
                        nums[k] = nums[k + gap];
                        nums[k + gap] = temp;
                        k--;
                    }
                }
            }
            if (gap == 1) {
                break;
            }
        }

        Long cost = System.currentTimeMillis() - start;
        System.out.println("希尔排序耗时:" + cost);

    }

}
