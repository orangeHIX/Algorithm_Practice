package com.creaty.leetcode;

import java.util.Arrays;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
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

    public static void main(String[] args) {
        BestTimetoBuyandSellStock.maxProfit(new int[]{1, 2, 3, 4, 11, 8, 5, 4, 1, 5, 9});
    }
}
