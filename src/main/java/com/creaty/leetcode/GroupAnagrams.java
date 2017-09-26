package com.creaty.leetcode;

import java.util.*;

/**
 * Created by hyx on 2017/9/24.
 */
public class GroupAnagrams {

    public static class Fingerprint{
        int[] fingerprint;
        public  Fingerprint(String s){
            fingerprint = new int[26];
            char[] cs = s.toCharArray();
            for(char c : cs){
                fingerprint[c-'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fingerprint that = (Fingerprint) o;

            return Arrays.equals(fingerprint, that.fingerprint);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(fingerprint);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Fingerprint, List<String>> map = new HashMap<>();
        for(String s:strs){
            Fingerprint f = new Fingerprint(s);
            if(map.containsKey(f)){
                map.get(f).add(s);
            }else{
                List<String> list =new ArrayList<>();
                list.add(s);
                map.put(f, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
