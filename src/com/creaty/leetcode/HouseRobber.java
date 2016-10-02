package com.creaty.leetcode;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 * Created by hyx on 2015/10/14.
 */
public class HouseRobber {

    public static int rob(int[] nums, int start, int end){
        int maxMoney = 0;
        int maxMoneyRob = 0;
        int maxMoneyNotRob = 0;

        for(int i = start; i < end; i++){
            maxMoneyRob = maxMoneyNotRob + nums[i];
            maxMoneyNotRob = maxMoney;
            maxMoney = maxMoneyRob > maxMoneyNotRob ? maxMoneyRob : maxMoneyNotRob;
        }
        return maxMoney;
    }

    public static int rob(int[] nums) {
        return rob(nums, 0, nums.length);
    }

    public static void main(String[] args){
        System.out.println(rob(new int[]{2,4,13,7,1,5}));
    }
}
