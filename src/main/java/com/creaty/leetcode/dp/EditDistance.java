package com.creaty.leetcode.dp;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * Created by hzhuangyixuan on 2017/8/1.
 */
public class EditDistance {

    public int minDistance2(String word1, String word2) {
        int m = word1.length() + 1, n = word2.length() + 1;
        int[] cur = new int[m];
        for (int i = 0; i < m; i++) {
            cur[i] = i;
        }
        for (int j = 1; j < n; j++) {
            int pre = cur[0];
            cur[0] = j;
            for (int i = 1; i < m; i++) {
                int temp = cur[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[i] = pre;
                } else {
                    cur[i] = Math.min(Math.min(pre + 1,
                            cur[i] + 1), cur[i - 1] + 1);
                }
                pre = temp;
            }
        }
        return cur[m - 1];
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1, n = word2.length() + 1;
        int[][] dp = new int[m][];
        for (int i = 0; i < m; i++) {
            dp[i] = new int[n];
            dp[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 1,
                            dp[i][j - 1] + 1), dp[i - 1][j] + 1);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
