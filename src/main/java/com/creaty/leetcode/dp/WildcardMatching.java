package com.creaty.leetcode.dp;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples: <br>
 * isMatch("aa","a") ? false <br>
 * isMatch("aa","aa") ? true <br>
 * isMatch("aaa","aa") ? false <br>
 * isMatch("aa", "*") ? true <br>
 * isMatch("aa", "a*") ? true <br>
 * isMatch("ab", "?*") ? true <br>
 * isMatch("aab", "c*a*b") ? false <br>
 * Created by hzhuangyixuan on 2017/8/1.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] b = new boolean[s.length() + 1][];
        for (int i = 0; i < s.length() + 1; i++) {
            b[i] = new boolean[p.length() + 1];
        }
        b[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            b[i + 1][0] = false;
        }
        for (int j = 0; j < p.length(); j++) {
            b[0][j + 1] = '*' == p.charAt(j) && b[0][j];
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    b[i + 1][j + 1] = b[i][j] && ('?' == p.charAt(j) || s.charAt(i) == p.charAt(j));
                } else {
                    b[i + 1][j + 1] = b[i + 1][j] || b[i][j + 1];
                }
            }
        }
        return b[s.length()][p.length()];
    }
}
