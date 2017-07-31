package com.creaty.leetcode.dp;

/**
 * Created by hzhuangyixuan on 2017/7/31.
 */
public class RegularExpressionMatching {
    boolean helper(String s, String p, int i, int j){
        if (j == p.length())    return i == s.length();

        if(j==p.length()-1 || p.charAt(j+1)!= '*'){
            if(i==s.length() || s.charAt(i)!= p.charAt(j) && p.charAt(j) != '.')
                return false;
            else
                return helper(s, p,i+1,j+1);
        }else{      // p.charAt(j+1)== '*'
            while(i<s.length() && (p.charAt(j)=='.' || s.charAt(i) == p.charAt(j))){
                if(helper(s,p,i,j+2))
                    return true;
                i++;
            }
            return helper(s,p,i,j+2);
        }
    }
    boolean isMatch(String s, String p) {
        return helper(s,p,0,0);
    }

    boolean isMatch2(String s, String p){
        boolean[][] b = new boolean[s.length()][];
        for(int i = 0; i < s.length()+1; i++){
            b[i] = new boolean[p.length()];
        }
        b[0][0] = true;
        for(int i = 0; i < s.length(); i++){
            b[i+1][0] = false;
        }
        for(int j = 0; j < p.length(); j++){
            b[0][j+1] = j > 0 && '*' == p.charAt(j) && b[0][j-1];
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    b[i + 1][j + 1] = b[i][j] && ('.' == p.charAt(j) || s.charAt(i) == p.charAt(j));
                } else {
                    b[i + 1][j + 1] = j > 0 && b[i + 1][j - 1]
                            || b[i + 1][j]
                            || b[i][j + 1] && j > 0 && ('.' == p.charAt(j-1) || s.charAt(i) == p.charAt(j-1));
                }
            }
        }
        return b[s.length()][p.length()];
    }
}
