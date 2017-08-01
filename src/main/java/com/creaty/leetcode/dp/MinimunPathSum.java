package com.creaty.leetcode.dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * Created by hzhuangyixuan on 2017/8/1.
 */
public class MinimunPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[] cur = new int[row];
        cur[0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            cur[i] = cur[i - 1] + grid[i][0];
        }
        for (int j = 1; j < column; j++) {
            cur[0] += grid[0][j];
            for (int i = 1; i < row; i++) {
                cur[i] = (cur[i - 1] < cur[i] ? cur[i - 1] : cur[i]) + grid[i][j];
            }
        }
        return cur[row - 1];
    }
}
