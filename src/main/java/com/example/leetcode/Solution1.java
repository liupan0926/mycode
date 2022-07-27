package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 你可以按任意顺序返回答案。 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 类Solution1.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 13, 2022 6:31:09 PM
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] nums = { 3, 3 };

        System.out.println(twoSum(nums, 6)[0] + "_" + twoSum(nums, 6)[1]);
    }

    /**
     * 不能要排序的办法，index打乱了
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = { -1, -1 };

        //key 值， value,数组下标
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                res[1] = i;
                //之前的值
                res[0] = hashMap.get(nums[i]);
            }

            //下标对应的 需要的值
            hashMap.put(target - nums[i], i);
        }

        return res;
    }
}
