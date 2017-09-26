package com.creaty.leetcode;

/**
 * Created by hyx on 2017/9/25.
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int curEnd = 0, curFarthest = 0;
        int i = 0;
        for (; i <= curEnd && i < nums.length; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                curEnd = curFarthest;
            }
        }
        return i == nums.length;
    }
    public static void main(String[] args){
        canJump(new int[]{2,3,1,1,4});
    }
}
