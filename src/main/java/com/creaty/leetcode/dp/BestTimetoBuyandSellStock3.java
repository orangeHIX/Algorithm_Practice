package com.creaty.leetcode.dp;

/**
 * Created by hyx on 2017/9/18.
 */
public class BestTimetoBuyandSellStock3 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        else{
            int k = 2;
            int[][] dp = new int[k+1][];
            int maxProf = 0;
            for(int i = 0; i < k+1; i++){
                dp[i] = new int[prices.length];
            }
            for(int kk = 1; kk <= k; kk++){
                int tmpMax = dp[kk-1][0] - prices[0];
                for(int ii = 1; ii < prices.length; ii++){
                    dp[kk][ii] = Math.max(dp[kk][ii-1], prices[ii]+tmpMax);
                    tmpMax = Math.max(tmpMax, dp[kk-1][ii] - prices[ii]);
                    maxProf = Math.max(dp[kk][ii], maxProf);
                }
            }
            return maxProf;
        }
    }
}
