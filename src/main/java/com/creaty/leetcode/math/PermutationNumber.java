package com.creaty.leetcode.math;

/**
 * Created by hzhuangyixuan on 2017/8/8.
 */
public class PermutationNumber {
    public static String getPermutation(int n, int k) {
        int i,j,f=1;
        // left part of s is partially formed permutation, right part is the leftover chars.
        char[] s = new char[n];
        for(i=1;i<=n;i++){
            f*=i;
            s[i-1]+='0'+i; // make s become 1234...n
        }
        for(i=0,k--;i<n;i++){
            f/=n-i;
            j=i+k/f; // calculate index of char to put at s[i]
            char c=s[j];
            // remove c by shifting to cover up (adjust the right part).
            for(;j>i;j--)
                s[j]=s[j-1];
            k%=f;
            s[i]=c;
        }
        return new String(s);
    }
    public static void main(String[] args){
        getPermutation(3,2);
    }
}
