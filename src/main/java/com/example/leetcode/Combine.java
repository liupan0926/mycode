package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/ 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k
 * 个数的组合。 你可以按 任何顺序 返回答案。
 * 
 * @author liupan Jun 8, 2022 11:45:49 AM
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(combine(5, 3));
    }

    /**
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> rr = new ArrayList<>();

        addInteger(res, rr, 1, n, k, k);
        //使用回溯算法来求组合问题
        return res;

    }

    /**
     * 从i开始到n的，j个数
     * 
     * @param rr
     * @param i
     * @param j
     */
    private static void addInteger(List<List<Integer>> res, List<Integer> rr, int i, int n, int k, int allK) {
        if (k == 0) {
            //这里是rr的引用，是不行的.
            res.add(new ArrayList<>(rr));
            return;
        }

        for (; i <= n; i++) {
            rr.add(i);
            addInteger(res, rr, i + 1, n, k - 1, allK);
            //从末尾删除，不影响迭代顺序，是可以的
            //这里remove不是i, 得是第几个数 ,全局k - 当前的k,等于要删的地址
            rr.remove(allK - k);
        }

    }
}
