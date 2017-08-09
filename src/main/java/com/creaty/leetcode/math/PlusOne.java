package com.creaty.leetcode.math;

/**
 * Created by hzhuangyixuan on 2017/8/8.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newN = new int[digits.length+1];
        newN[0] = 1;
        return newN;
    }
}
