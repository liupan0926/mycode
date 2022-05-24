package com.example.leetcode;

/**
 * <pre>
 *  给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    返回容器可以储存的最大水量。
    说明：你不能倾斜容器。
 * </pre>
 * 
 * 类MaxArea.java的实现描述：TODO 类实现描述
 * 
 * @author liupan May 24, 2022 10:53:51 AM
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        //        //最大面积
        //        int maxArea = 0;
        //        //迭代穷举，得到最大面积
        //        for (int i = 0; i < height.length; i++) {
        //            int height1 = height[i];
        //            //不需要向左
        //            for (int j = i + 1; j < height.length; j++) {
        //                int height2 = height[j];
        //                //面积高度
        //                int calH = height1 <= height2 ? height1 : height2;
        //                int calL = j - i;
        //                int tempArea = calH * calL;
        //                if (tempArea > maxArea) {
        //                    maxArea = tempArea;
        //                }
        //            }
        //        }
        //
        //        return maxArea;

        //上面代码会超时，使用双指针的算法
        int maxArea = 0;

        //最左边
        int min = 0;
        //最右边
        int max = height.length - 1;

        while (min != max) {
            int calL = max - min;
            int height1 = height[min];
            int height2 = height[max];

            int calH = height1 <= height2 ? height1 : height2;
            int tempArea = calL * calH;

            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            //这里需要确认移动那个指针

            if (height1 <= height2) {
                min = min + 1;
            } else {
                max = max - 1;
            }

        }

        return maxArea;

    }

}
