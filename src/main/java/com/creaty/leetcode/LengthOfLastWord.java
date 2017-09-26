package com.creaty.leetcode;

/**
 * Created by hyx on 2017/9/27.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] ca = s.toCharArray();
        int i = ca.length-1;
        int len = 0;
        while(i >= 0 && ca[i] == ' ') i--;
        while(i >= 0 && ca[i] != ' '){
            len++;
            i--;
        }
        return len;
    }
}
