package com.creaty.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhuangyixuan on 2017/7/26.
 */
public class SubstringConcatenationAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words.length < 1) return result;
        int len = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                String sub = s.substring(i + j * len, i + j * len + len);
                if (copy.containsKey(sub)) {
                    int c = copy.get(sub);
                    if (c == 1) {
                        copy.remove(sub);
                        if (copy.isEmpty()) {
                            result.add(i);
                            break;
                        }
                    } else {
                        copy.put(sub, c - 1);
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }
}
