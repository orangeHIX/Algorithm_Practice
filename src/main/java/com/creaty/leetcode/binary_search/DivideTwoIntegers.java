package com.creaty.leetcode.binary_search;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 * <p>
 * Created by hzhuangyixuan on 2017/7/28.
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend == Integer.MIN_VALUE || divisor == 0) return Integer.MAX_VALUE;
        boolean isNeg = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) isNeg = true;

        long x = Math.abs((long) dividend);
        long a = Math.abs((long) divisor);
        int i = 0;
        while (a << (i + 1) <= x) i++;

        int result = 0;
        while (x >= a) {
            if (x >= a << i) {
                x -= a << i;
                result += 1 << i;
            }
            i--;
        }
        return isNeg ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
