package com.creaty.interview;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by hyx on 2017/9/18.
 */
public class Factorial {

    public static String addOne(String s){
        char[] result = new char[s.length() + 1];
        int flag = 1;
        for (int k = s.length()-1; k > 0; k--){
            int r = s.charAt(k) - '0' + flag;
            if(r == 10){
                result[k+1] = '0';
                flag = 0;
            }else {
                result[k+1] = (char) (r%10 + '0');
                flag = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(result[i] == 0) i++;
        for(; i < result.length; i++){
            sb.append(result[i]);
        }
        //System.out.println("result " + sb.toString());
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public static String bigNumberMultiply(String num1, String num2){
        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++){
            for (int j = 0; j < num2.length(); j++){
                //ystem.out.println(num1+","+num2+", " + i +","+j );
                result[i + j + 1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        //单独处理进位
        for(int k = result.length-1; k > 0; k--){
            if(result[k] > 10){
                result[k - 1] += result[k] / 10;
                result[k] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(result[i] == 0) i++;
        for(; i < result.length; i++){
            sb.append(result[i]);
        }
        //System.out.println("result " + sb.toString());
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String fact(long n){
        String result = "1";
        for(long i = 0; i <= n; i++){
            result = bigNumberMultiply(result, String.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(addOne("9"));
        System.out.println(bigNumberMultiply("1","2"));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(fact(n));
        }
    }
}
