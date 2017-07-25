package com.creaty.leetcode;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,<br/>
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Created by hyx on 2015/11/9.
 */
public class IsomorphicStrings {


    public boolean isIsomorphic(String s, String t) {
        return half(s, t) && half(t, s);
    }

    private boolean half(String s, String t) {
        HashMap<Character, Character> dic = new HashMap<>();
//        char[] sarr = s.toCharArray();
//        char[] tarr = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (dic.containsKey(sc)) {
                if (dic.get(sc) != tc) {
                    return false;
                }
            } else {
                dic.put(sc, tc);
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> dic = new HashMap<>();
        HashMap<Character, Character> reDic = new HashMap<>();
//        char[] sarr = s.toCharArray();
//        char[] tarr = t.toCharArray();
        Character re1;
        Character re2;
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if ((re1 = dic.get(sc)) != null) {
                if (re1 != tc) {
                    return false;
                }
            } else if ((re2 = reDic.get(tc)) != null) {
                if (re2 != sc) {
                    return false;
                }
            } else {
                dic.put(sc, tc);
                reDic.put(tc, sc);
            }
        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {

        char[] dic = new char[256];
        char[] reDic = new char[256];
        //HashMap<Character, Character> dic = new HashMap<>();
//        HashMap<Character, Character> reDic = new HashMap<>();
//        char[] sarr = s.toCharArray();
//        char[] tarr = t.toCharArray();
        char re1;
        char re2;
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if ((re1 = dic[sc]) != 0) {
                if (re1 != tc) {
                    return false;
                }
            } else if ((re2 = reDic[tc]) != 0) {
                if (re2 != sc) {
                    return false;
                }
            } else {
                dic[sc] = tc;
                reDic[tc] = sc;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic3("egg", "add"));
        System.out.println(is.isIsomorphic3("foo", "bar"));
        System.out.println(is.isIsomorphic3("paper", "title"));
    }
}
