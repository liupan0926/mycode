package com.example.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 90000; i++) {
            list.add(i);
        }
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int random = r.nextInt(10000);
            list.add(random);
        }

        System.out.println("初始数组：" + list);
        //int[] nums = { 3, 2, 4, 1, 5, 5, 6, 2, 1, 4, 5, 6 };

        Integer[] numss = new Integer[list.size()];

        numss = list.toArray(numss);

        int[] nums = new int[numss.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numss[i];
        }

        //SortUtils.printfNums(nums);

        //InsertSort.insertSort(nums);
        //BubbleSort.bubbleSort(nums);
        //QuickSort.quickSort(nums);
        //SelectSort.selectSort(nums);
        shellSort(nums);

        //SortUtils.printfNums(nums);
    }

    public static void shellSort(int[] nums) {

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
