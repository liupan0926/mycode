package com.example.sort;

/**
 * 堆排序https://www.runoob.com/w3cnote/heap-sort.html
 * 
 * @author liupan Jun 23, 2022 3:34:10 PM
 */
public class HeapSort {

    public void heapSort(int[] nums) {
        //第一个非叶子节点 的索引 
        int index = nums.length / 2 - 1;
        //从下至上构建大顶堆。
        int left = 2 * index + 1;
        int right = 2 * index + 2;
    }

}
