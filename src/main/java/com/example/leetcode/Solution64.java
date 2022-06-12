package com.example.leetcode;

/**
 * <pre>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
 * 
 * 说明：每次只能向下或者向右移动一步。
 * </pre>
 * 
 * @author liupan Jun 12, 2022 2:52:32 PM
 */
public class Solution64 {

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        //使用动态规划算法。
        //dp[i][j] 定义 为到 [i,j] 的最短路径
        //dp[i][j-1] + grid[i,j]  和 dp[i-1][j]+grid[i,j]里的最小值
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
                } else if (j > 0) { //i==0
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (i > 0) { //j==0
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else { //i==0,j==0
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
