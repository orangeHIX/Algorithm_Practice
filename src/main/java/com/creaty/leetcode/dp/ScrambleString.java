package com.creaty.leetcode.dp;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * Created by hzhuangyixuan on 2017/8/3.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        /*
         * Let F(i, j, k) = whether the substring S1[i..i + k - 1] is a scramble of S2[j..j + k - 1] or not
         * Since each of these substrings is a potential node in the tree, we need to check for all possible cuts.
         * Let q be the length of a cut (hence, q < k), then we are in the following situation:
         *
         * S1 [   x1    |         x2         ]
         *    i         i + q                i + k - 1
         *
         * here we have two possibilities:
         *
         * S2 [   y1    |         y2         ]
         *    j         j + q                j + k - 1
         *
         * or
         *
         * S2 [       y1        |     y2     ]
         *    j                 j + k - q    j + k - 1
         *
         * which in terms of F means:
         *
         * F(i, j, k) = for some 1 <= q < k we have:
         *  (F(i, j, q) AND F(i + q, j + q, k - q)) OR (F(i, j + k - q, q) AND F(i + q, j, k - q))
         *
         * Base case is k = 1, where we simply need to check for S1[i] and S2[j] to be equal
         * */
        boolean[][][] F = new boolean[len][len][len + 1];
        for (int k = 1; k <= len; ++k)
            for (int i = 0; i + k <= len; ++i)
                for (int j = 0; j + k <= len; ++j)
                    if (k == 1)
                        F[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    else for (int q = 1; q < k && !F[i][j][k]; ++q) {
                        F[i][j][k] = (F[i][j][q] && F[i + q][j + q][k - q]) || (F[i][j + k - q][q] && F[i + q][j][k - q]);
                    }
        return F[0][0][len];
    }
}
