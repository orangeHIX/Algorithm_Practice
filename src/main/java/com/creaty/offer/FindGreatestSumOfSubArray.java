package com.creaty.offer;

import java.util.Arrays;

/**
 * Created by hyx on 2017/9/14.
 */
public class FindGreatestSumOfSubArray {

    public static int findGreatestSumOfSubArray(int[] arr){
        if(arr == null) return 0;
        int max = 0;
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(sum<=0) sum = arr[i];
            else sum += arr[i];
            if(sum > max) max = sum;
        }
        return max;
    }

    public static int findGreatestSumOfSubArrayDP(int[] arr){
        if(arr == null) return 0;
        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(i == 0 || dp[i-1] < 0) dp[i] = arr[i];
            else dp[i] = arr[i] + dp[i-1];
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args){
        System.out.println(findGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
        System.out.println(findGreatestSumOfSubArrayDP(new int[]{1,-2,3,10,-4,7,2,-5}));
    }
}
