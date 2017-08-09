package com.creaty.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhuangyixuan on 2017/8/8.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> T = new HashMap<>();
        T.put('I',1);
        T.put('V',5);
        T.put('X',10);
        T.put('L',50);
        T.put('C',100);
        T.put('D',500);
        T.put('M',1000);

        int sum = T.get(s.charAt(s.length()-1));
        int pre = sum;
        int cur = 0;
        for (int i = s.length() - 2; i >= 0; --i)
        {
            cur = T.get(s.charAt(i));
            if ( cur < pre)
            {
                sum -= cur;
            }
            else
            {
                sum += cur;
            }
            pre = cur;
        }

        return sum;
    }
}
