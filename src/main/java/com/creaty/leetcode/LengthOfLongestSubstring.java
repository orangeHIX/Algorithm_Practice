package com.creaty.leetcode;

import java.util.HashMap;

/**
 * Created by hzhuangyixuan on 2017/7/26.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty() ) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0, left = 0;
        int len = 0;
        for(;right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            len = Math.max(len, right-left+1);
        }
        return len;
    }
}
