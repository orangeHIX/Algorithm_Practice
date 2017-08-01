package com.creaty.leetcode.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Created by hyx on 2015/11/8.
 */
public class UniquePaths {

    public static void main(String[] args) {
        // write your code here
        System.out.println(new UniquePaths().uniquePaths(1, 1));
        System.out.println(new UniquePaths().uniquePaths2(36, 7));
        System.out.println(new UniquePaths().uniquePaths2_1(36, 7));
        System.out.println(new UniquePaths().uniquePaths2_2(1, 1));
    }

    public int uniquePaths(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double a = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++) {
            //System.out.println(""+a+","+b);
            a = a * (N - k + i) / i;
        }
        //System.out.println(""+a+","+b);
        return (int) a;
    }

    public int uniquePaths2(int m, int n) {

        int[][] way = new int[m][];
        for (int i = 0; i < m; i++) {
            way[i] = new int[n];
        }

        for (int i = 0; i < n; i++) {
            way[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            way[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                way[i][j] = way[i - 1][j] + way[i][j - 1];
            }
        }
        return way[m - 1][n - 1];
    }

    public int uniquePaths2_1(int m, int n) {

        if (m > n) return uniquePaths2_1(n, m);

        int[] pre = new int[m];
        int[] cur = new int[m];
        int[] temp;
        for (int i = 0; i < m; i++) {
            cur[i] = 1;
            pre[i] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                cur[i] = cur[i - 1] + pre[i];
            }
            temp = cur;
            cur = pre;
            pre = temp;
        }
        return pre[m - 1];
    }

    public int uniquePaths2_2(int m, int n) {

        if (m > n) return uniquePaths2_2(n, m);

        //int[] pre = new int[m];
        int[] cur = new int[m];
        for (int i = 0; i < m; i++) {
            cur[i] = 1;
            //pre[i] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                cur[i] += cur[i - 1]; //+ pre[i];
            }
//            temp = cur;
//            cur = pre;
//            pre = temp;
        }
        return cur[m - 1];
    }
}
