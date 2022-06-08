package com.example.leetcode;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 你只能选择 某一天 买入这只股票，并选择在
 * 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 类MaxProfit.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 8, 2022 11:06:53 AM
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = { 7, 2, 8, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        //最大收益 = max{n-1天的最大收益，第n天的价格-前n-1天的最小值}
        int min = 0;
        for (int n = 0; n < prices.length; n++) {
            if (n == 0) {
                min = prices[n];
            } else {
                min = prices[n] < min ? prices[n] : min;
                int temp = prices[n] - min;
                res = temp > res ? temp : res;
            }

        }

        return res;
    }

}
