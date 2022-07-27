package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/3sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * 类Solution15.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 12, 2022 4:58:18 PM
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] nums = { -1, -1, -1, 0, 1, 1, 2 };

        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        //双指针法，-1,-1,-1,0,1,1,2,此算法如何去重？
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                //循环直接终止
                return resList;
            }

            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resList.add(list);
                    //-1,-1,-1,0,1,1,2
                    //-1,-1,2以后 ，还有-1，0，1，这里不能跳出
                    //同时加减，否则可能还有重复
                    //这里还要去重
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                } else if (sum > 0) {
                    //右边的往左
                    right--;
                } else {
                    left++;
                }
            }
        }

        return resList;

    }

}
