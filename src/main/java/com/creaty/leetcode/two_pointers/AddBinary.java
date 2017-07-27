package com.creaty.leetcode.two_pointers;

/**
 * Created by hzhuangyixuan on 2017/7/27.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if("0".equals(a) && "0".equals(b)) return "0";
        char[] result = new char[Math.max(a.length(),b.length())+1];
        int i = a.length()-1;
        int j = b.length()-1;
        int k = 0;
        int c1 = 0, c2 = 0, c3 = 0;
        while(i >= 0 || j >= 0){
            c1 = c2 = 0;
            if( i >= 0 ) c1 = a.charAt(i)-'0';
            if( j >= 0 ) c2 = b.charAt(j)-'0';
            int sum = c1 + c2 + c3;
            if( sum == 3){
                result[k] = '1';
                c3 = 1;
            }else if( sum == 2){
                result[k] = '0';
                c3 = 1;
            }else if( sum == 1){
                result[k] = '1';
                c3 = 0;
            }else{
                result[k] = '0';
                c3 = 0;
            }
            i--;
            j--;
            k++;
        }
        if(c3 != 0){
            result[k] = '1';
            k++;
        }
        StringBuilder sb = new StringBuilder();
        int start = k-1;
        while(start >= 0 && result[start] == '0') start--;
        for(int m = start; m >= 0 ; m--){
            sb.append(result[m]);
        }
        return sb.toString();
    }
}
