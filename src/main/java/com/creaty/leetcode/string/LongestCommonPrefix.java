package com.creaty.leetcode.string;

/**
 * Created by hyx on 2017/9/20.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return null;
        if(strs.length < 1 || strs[0].length() < 1) return "";
        int i = 0;
        while(true){
            if(i >= strs[0].length()){
                break;
            }
            char c = strs[0].charAt(i);
            boolean flag = true;
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c ){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
            i++;
        }
        return strs[0].substring(0, i);
    }
}
