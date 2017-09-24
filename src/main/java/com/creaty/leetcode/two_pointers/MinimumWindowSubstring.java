package com.creaty.leetcode.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * Created by hzhuangyixuan on 2017/7/27.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int count = t.length();

        int subLen = Integer.MAX_VALUE;
        for (Character c : t.toCharArray()) {
            map.merge(c,1, (val, one)->val+one);
        }

        int head = 0, i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            Integer ci = map.get(c);
            if (ci != null) {
                if (ci > 0) count--;
                map.put(c, ci - 1);
            }
            j++;
            while (count == 0) {
                if (j - i < subLen) {
                    subLen = j - i;
                    head = i;
                }
                c = s.charAt(i);
                ci = map.get(c);
                if (ci != null) {
                    map.put(c, ci + 1);
                    if (ci + 1 > 0)
                        count++;
                }
                i++;
            }
        }
        if (subLen != Integer.MAX_VALUE) return s.substring(head, head + subLen);
        return "";
    }

    public static void main(String[] args) {
        minWindow("bba", "ab");
    }
}
