package com.creaty.leetcode.two_pointers;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * <p>
 * Created by hzhuangyixuan on 2017/7/28.
 */
public class ValidPalindrome {
    private boolean isAlphanumeric(char c) {
        if (c >= '0' && c <= '9') return true;
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;
        String ls = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char c1 = ls.charAt(i);
            if (!isAlphanumeric(c1)) {
                i++;
                continue;
            }
            char c2 = ls.charAt(j);
            if (!isAlphanumeric(c2)) {
                j--;
                continue;
            }
            if (c1 != c2) return false;
            i++;
            j--;
        }
        return true;
    }
}
