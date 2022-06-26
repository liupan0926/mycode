package com.example.sort;

/**
 * 斐波那契数列 类Fxfunction.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 24, 2022 5:04:27 PM
 */
public class Fxfunction {

    public static void main(String[] args) {

        int n = 1000;
//        long start = System.currentTimeMillis();
//        int res = fx(n);
//        Long cost = System.currentTimeMillis() - start;
//        System.out.println("递归耗时:" + cost);
//        System.out.println("f" + n + ":" + res);

        long start1 = System.currentTimeMillis();
        int ress = fxDynamic(n);
        Long cost1 = System.currentTimeMillis() - start1;
        System.out.println("动态规划耗时:" + cost1);
        System.out.println("f" + n + ":" + ress);
    }

    /**
     * 动态规划实现
     * 
     * @param x
     * @return
     */
    public static int fxDynamic(int x) {
        //所谓的动态规划 ，是将递归计算的结果保存到数组中，这样会减少堆栈的深度.

        //x=0时，不能报错
        int[] f = new int[x + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= x; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        int res = f[x];
        return res;
    }

    public static int fx(int n) {
        int res = 0;
        if (n == 0) {
            res = 0;
        } else if (n == 1 || n == 2) {
            res = 1;
        } else if (n > 2) {
            res = fx(n - 1) + fx(n - 2);
        } else {
            res = -1;
        }
        return res;
    }

}
