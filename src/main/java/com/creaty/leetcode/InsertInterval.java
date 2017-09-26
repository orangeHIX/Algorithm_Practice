package com.creaty.leetcode;

import com.creaty.leetcode.utility.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyx on 2017/9/27.
 */
public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        Interval interval = null;
        for(;i<intervals.size();i++){
            interval = intervals.get(i);
            if(interval.end >= newInterval.start) break;
            result.add(interval);
        }

        int start = newInterval.start;
        int end = newInterval.end;
        for(;i<intervals.size();i++){
            interval = intervals.get(i);
            if(interval.start > newInterval.end) break;
            start = Math.min(interval.start,start);
            end = Math.max(interval.end,end);
        }
        result.add(new Interval(start, end));
        for(;i<intervals.size();i++){
            interval = intervals.get(i);
            result.add(interval);
        }
        return result;
    }
    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        Interval newInterval = new Interval(4,9);
        System.out.println(insert(intervals,newInterval));
    }
}
