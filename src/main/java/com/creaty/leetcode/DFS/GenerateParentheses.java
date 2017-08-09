package com.creaty.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhuangyixuan on 2017/8/9.
 */
public class GenerateParentheses {
    private void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        if(open < max){
            backtrack(list, str+'(', open+1, close, max);
        }
        if(close < open){
            backtrack(list, str+')', open, close+1, max);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }
}
