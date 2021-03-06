package com.creaty.leetcode.dp;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.


 * Created by hzhuangyixuan on 2017/8/4.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if( s == null || s.isEmpty() ) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1: 0;
        for(int i = 2; i < s.length()+1; i++){
            int oneDigit = s.charAt(i-1)-'1'+1;
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            if(oneDigit >= 1 && oneDigit <= 9){
                dp[i] += dp[i-1];
            }
            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
