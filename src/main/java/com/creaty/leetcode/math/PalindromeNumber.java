package com.creaty.leetcode.math;

/**
 * Created by hzhuangyixuan on 2017/8/4.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int k = 1;
        if(x < 0) return false;
        while((x/k) >= 10) k = k*10;
        while(x > 0){
            if(x%10 != x/k) return false;
            x = x%k;
            x = x/10;
            k = k/100;
        }
        return true;
    }
}
