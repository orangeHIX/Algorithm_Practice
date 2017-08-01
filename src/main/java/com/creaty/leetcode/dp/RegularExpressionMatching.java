package com.creaty.leetcode.dp;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") ? true <br>
 * isMatch("aa", ".*") ? true <br>
 * isMatch("ab", ".*") ? true <br>
 * isMatch("aab", "c*a*b") ? true <br>
 * Created by hzhuangyixuan on 2017/7/31.
 */
public class RegularExpressionMatching {
    boolean helper(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();

        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (i == s.length() || s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')
                return false;
            else
                return helper(s, p, i + 1, j + 1);
        } else {      // p.charAt(j+1)== '*'
            while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                if (helper(s, p, i, j + 2))
                    return true;
                i++;
            }
            return helper(s, p, i, j + 2);
        }
    }

    boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    boolean isMatch2(String s, String p) {
        boolean[][] b = new boolean[s.length() + 1][];
        for (int i = 0; i < s.length() + 1; i++) {
            b[i] = new boolean[p.length() + 1];
        }
        b[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            b[i + 1][0] = false;
        }
        for (int j = 0; j < p.length(); j++) {
            b[0][j + 1] = j > 0 && '*' == p.charAt(j) && b[0][j - 1];
        }
        /**
         * b[i + 1][j + 1]: if s[0..i] matches p[0..j]
         * if p[j] != '*'
         * b[i + 1][j + 1] = b[i][j] && s[i] == p[j]
         * if p[j] == '*', denote p[j - 1] with x,
         * then b[i + 1][j + 1] is true iff any of the following is true
         * 1) "x*" repeats 0 time and matches empty: b[i + 1][j -1]
         * 2) "x*" repeats 1 time and matches x: b[i + 1][j]
         * 3) "x*" repeats >= 2 times and matches "x*x": s[i] == x && b[i][j + 1]
         * '.' matches any single character
         */
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) != '*') {
                    b[i + 1][j + 1] = b[i][j] && ('.' == p.charAt(j) || s.charAt(i) == p.charAt(j));
                } else {
                    b[i + 1][j + 1] = j > 0 && b[i + 1][j - 1]
                            || b[i + 1][j]
                            || b[i][j + 1] && j > 0 && ('.' == p.charAt(j - 1) || s.charAt(i) == p.charAt(j - 1));
                }
            }
        }
        return b[s.length()][p.length()];
    }
}
