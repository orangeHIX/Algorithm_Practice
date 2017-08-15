package com.creaty.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * Created by hzhuangyixuan on 2017/8/11.
 */
public class RestoreIPAddresses {
    private List<String> result;
    private String s;
    private void dfs(int dotIndex, String restored, int count){
        if(count == 4 && dotIndex == s.length()){
            result.add(restored);
            return;
        }
        if(count >= 4) return;
        for(int i = 1; i < 4; i++){
            if(dotIndex+i>s.length() ) break;
            if(s.length()-dotIndex-i > 3*(4-count)) continue;
            String substr = s.substring(dotIndex, dotIndex+i);
            if(substr.charAt(0) == '0' && substr.length() > 1)
                break;
            if(i==3 && Integer.parseInt(substr) > 255)
                continue;
            dfs(dotIndex+i,restored+substr+(count==3?"":"."),count+1);
        }

    }
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        this.s = s;
        dfs(0, "", 0);
        return result;
    }
}
