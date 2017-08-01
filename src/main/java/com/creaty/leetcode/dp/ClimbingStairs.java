package com.creaty.leetcode.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * Created by hzhuangyixuan on 2017/8/1.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;

        int last1 = 2;
        int last2 = 1;
        int cur = 0;
        for (int i = 2; i < n; i++) {
            cur = last1 + last2;
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }
}
