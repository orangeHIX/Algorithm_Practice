package com.creaty.leetcode.dp;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Created by hyx on 2017/9/18.
 */
public class BestTimetoBuyandSellStock2 {
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
}
