package com.example.leetcode;

/**
 * <pre>
 *  给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
    假设环境不允许存储 64 位整数（有符号或无符号）。
 * </pre>
 * 
 * @author liupan May 27, 2022 4:45:55 PM
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;

        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        //321 -> 123
        int y = Math.abs(x);

        long res = 0;
        while (y > 0) {
            int n = y % 10;
            int m = y / 10;
            res = res * 10 + n;
            y = m;
        }
        if (x < 0) {
            res = -res;
        }
        return (int) res == res ? (int) res : 0;
    }

    //    /**
    //     * m的x次方
    //     * 
    //     * @param m
    //     * @param x
    //     * @return
    //     */
    //    public static int pingfang(int m, int x) {
    //        int res = 1;
    //        while (x > 0) {
    //            res = res * m;
    //            x--;
    //        }
    //        return res;
    //    }
}
