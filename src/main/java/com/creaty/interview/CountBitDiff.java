package com.creaty.interview;

/**
 * Created by hyx on 2017/9/18.
 */
public class CountBitDiff {
    public static int countBitDiff(int m, int n) {
        int val = m^n;
        int count = 0;
        while(val != 0){
            count++;
            val = val&(val-1);
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(countBitDiff(1999,2299));
    }
}
