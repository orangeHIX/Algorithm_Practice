package com.creaty.leetcode.utility;

/**
 * Created by hyx on 2017/9/26.
 */
public class Interval {

    public int start;
    public int end;

    Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "["+start +
                "," + end +
                ']';
    }
}
