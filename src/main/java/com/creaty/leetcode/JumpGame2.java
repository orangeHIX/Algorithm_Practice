package com.creaty.leetcode;

/**
 * Created by hyx on 2017/9/24.
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        if(n<2) return 0;
        int level = 0, curMax = 0, i = 0, nextMax = 0;
        while(curMax-i+1>0){
            level++;
            for(;i<=curMax;i++){
                nextMax= Math.max(nextMax, nums[i]+i);
                if(nextMax >= n - 1) return level;
            }
            curMax = nextMax;
        }
        return 0;
    }
    public int jump2(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
