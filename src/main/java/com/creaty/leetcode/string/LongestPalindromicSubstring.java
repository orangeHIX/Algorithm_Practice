package com.creaty.leetcode.string;

/**
 * Created by hyx on 2017/9/20.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.isEmpty()) return "";
        int low = 0, maxLen = 1;
        for(int i = 0; i < s.length();){
            if(s.length()-i <= maxLen/2) break;
            int j = i, k = i;
            while(k < s.length()-1 &&s.charAt(k+1) == s.charAt(k)) k++;
            i = k+1;
            while(k < s.length()-1 && j > 0 && s.charAt(j-1) == s.charAt(k+1)){
                k++;
                j--;
            }
            int newLen = k-j+1;
            if(newLen > maxLen){
                low = j;
                maxLen = newLen;
            }
        }
        return s.substring(low, low+maxLen);
    }
}
