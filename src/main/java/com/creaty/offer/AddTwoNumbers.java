package com.creaty.offer;

/**
 * Created by hyx on 2017/9/19.
 */
public class AddTwoNumbers {

    public static int add(int num1, int num2){
        int sum, carry;
        do{
            sum = num1^num2;
            carry = (num1&num2) << 1;

            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return num1;
    }

    public static void main(String[] args){
        System.out.println(add(-11,111));
    }
}
