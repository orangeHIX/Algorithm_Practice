package com.creaty.leetcode.dp;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 * Created by hyx on 2015/11/19.
 */
public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int[] highestPriceAftertheDay = new int[prices.length];
        int highestPrice = -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            highestPriceAftertheDay[i] = highestPrice;
            if (prices[i] > highestPrice) {
                highestPrice = prices[i];
            }
        }
        System.out.println(Arrays.toString(prices));
        System.out.println(Arrays.toString(highestPriceAftertheDay));
        return 0;
    }
    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++){
            maxCur = Math.max(0, maxCur += prices[i] -prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock.maxProfit(new int[]{1, 2, 3, 4, 11, 8, 5, 4, 1, 5, 9});
    }
}
