package com.creaty.interview;

import java.util.Scanner;

/**
 * Created by hyx on 2017/9/18.
 */
public class Fibonacci {

    public static int num(int n){
        if( n < 0) return 0;
        else if( n == 0) return 1;
        else if( n == 1) return 1;
        return num(n-1) + num(n-2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(num(n));
        }
    }
}
