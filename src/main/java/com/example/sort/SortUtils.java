package com.example.sort;

import java.util.ArrayList;
import java.util.List;

public class SortUtils {

    public static void printfNums(int[] nums) {

        List<Integer> li = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            li.add(nums[i]);
        }
        System.out.println(li);
    }
}
