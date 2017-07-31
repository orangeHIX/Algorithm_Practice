package com.creaty.leetcode;

/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * <p>
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.<br\>
 * [<br\>
 * [0,0,0],<br\>
 * [0,1,0],<br\>
 * [0,0,0]<br\>
 * ]<br\>
 * <p>
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Created by hyx on 2015/11/8.
 */
public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(obstacleGrid));
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(new int[][]{{0, 1}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[] cur = new int[row];
        int w = 1;
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                w = 0;
            }
            cur[i] = w;
        }

        for (int j = 1; j < column; j++) {
            if (obstacleGrid[0][j] == 1)
                cur[0] = 0;
            for (int i = 1; i < row; i++) {
                if (obstacleGrid[i][j] == 1) {
                    cur[i] = 0;
                } else {
                    cur[i] += cur[i - 1];
                }
            }
        }
        return cur[row - 1];
    }
}
