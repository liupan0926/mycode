package com.example.leetcode;

/**
 * 删除有序数组中的重复项 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的
 * 相对顺序 应该保持 一致 。
 * 
 * <pre>
 *  输入：nums = [0,0,1,1,1,2,2,3,3,4]
    输出：5, nums = [0,1,2,3,4]
    解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
    
    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan Jun 1, 2022 8:27:29 PM
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int nums[] = { 0, 1,2};

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        /**
         * 双指针： 1.for循环整个数组,指向数组当前位置. 2.指针指向可以换位置的第一个元素所在位置。
         */
        Integer current = null;
        Integer curNum = null;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            //第一次进来
            if (curNum == null) {
                curNum = number;
            } else if (number == curNum) {
                //此位置可以被替换
                if (current == null) {
                    //确定了数组可替换的位置，一旦替换后 ，下个位置为此位置+1；
                    current = i;
                }
            } else {
                //如果不重复,就需要考虑挪动位置。
                if (current != null) { //有位置可挪
                    nums[current] = number;
                    //可替换的位置变成下个位置。
                    current = current + 1;
                }
                curNum = number;
            }

        }

        //代表没有重复的数
        if (current == null) {
            current = nums.length;
        }

        return current;
    }

}
