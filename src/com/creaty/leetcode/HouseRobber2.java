package com.creaty.leetcode;

/**
 *
 * Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will
 not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house
 is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the
 previous street.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 money you can rob tonight without alerting the police.

 * Created by hyx on 2015/10/14.
 */
public class HouseRobber2 {
    public static int rob(int[] nums){
        if(nums.length== 0) {
            return 0;
        }
        return Math.max(HouseRobber.rob(nums, 1, nums.length), nums[0] + HouseRobber.rob(nums, 2, nums.length -1));
    }
    public static void main(String args[]){

    }
}
