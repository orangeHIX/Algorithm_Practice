package com.creaty.leetcode;

import com.creaty.leetcode.utility.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hyx on 2017/9/26.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<1) return intervals;
        intervals.sort((o1, o2) -> o1.start-o2.start);
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval i : intervals){
            if(i.start <= end){
                end = Math.max(end, i.end);
            }else{
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
