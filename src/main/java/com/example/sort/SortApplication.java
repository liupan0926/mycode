package com.example.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortApplication {

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

        //System.out.println("初始数组：" + list);
        //int[] nums = { 3, 2, 4, 1, 5, 5, 6, 2, 1, 4, 5, 6 };

        Integer[] numss = new Integer[list.size()];

        numss = list.toArray(numss);

        int[] nums = new int[numss.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numss[i];
        }

        //InsertSort.insertSort(nums);
        //BubbleSort.bubbleSort(nums);
        QuickSort.quickSort(nums);
        //SelectSort.selectSort(nums);
        //ShellSort.shellSort(nums);

        //MergeSort.mergeSort(nums);

        //SortUtils.printfNums(nums);
    }

}
