package com.creaty.leetcode;

/**
 * Created by hzhuangyixuan on 2017/7/25.
 */
public class StringtoInteger {
    public static int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if( str.length() < 1 ) return 0;

        int sign = 1;
        int start  = 0;
        if(str.charAt(0) == '-'){
            sign = -1;
            start++;
        }else if(str.charAt(0) == '+' ){
            start++;
        }
        int r = 0;
        //char[] ca = str.toCharArray();
        for(int i = start; i < str.length(); i++){
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9 ) return 0;
            if(Integer.MAX_VALUE/10 < r || Integer.MIN_VALUE/10 == r && Integer.MAX_VALUE%10 < digit )
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            r = r*10 + digit;
        }
        return sign*r;
    }

    public static void main(String[] args){
        System.out.println(myAtoi("2147483648"));
    }
}
