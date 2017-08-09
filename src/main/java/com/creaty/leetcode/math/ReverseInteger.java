package com.creaty.leetcode.math;

/**
 * Created by hzhuangyixuan on 2017/8/4.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        boolean isNeg = false;
        if(x < 0){
            if(x == Integer.MIN_VALUE) return 0;
            isNeg = true;
            x = -x;
        }else if(x == 0) return 0;
        int result = x%10;
        while((x = x/10) != 0){
            if(result > Integer.MAX_VALUE/10
                    || result == Integer.MAX_VALUE/10 && x%10 > Integer.MAX_VALUE%10) return 0;
            result = result * 10 + x%10;
        }
        return isNeg ? -result: result;
    }
    public static void main(String[] args){
        System.out.println(reverse(-2147483648));
        System.out.println(Integer.MIN_VALUE);
    }
}
