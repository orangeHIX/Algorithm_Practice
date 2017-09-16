package com.creaty.offer;

/**
 * Created by hyx on 2017/9/14.
 */
public class NumberOfOne {

    public static int numbersOfOne(int n){
        int cur = n;
        int cnt = 0;
        int quotient = 0;
        int remainder = 0;
        int mult = 1;
        while(cur != 0){
            quotient = cur/10;
            remainder = cur%10;
            cnt += quotient * mult;

            if(remainder > 1) cnt += mult;
            else if(remainder == 1) cnt += n - cur*mult +1;

            cur /= 10;
            mult *= 10;
        }
        return cnt;
    }

    public static void main(String[] args){
        System.out.println(numbersOfOne(123456789));
    }

}
