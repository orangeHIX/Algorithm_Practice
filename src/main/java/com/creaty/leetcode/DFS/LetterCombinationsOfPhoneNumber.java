package com.creaty.leetcode.DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hzhuangyixuan on 2017/8/8.
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        result.add("");
        for(int i = 0; i < digits.length(); i++){
            int x = digits.charAt(i)-'0';
            while(result.peek().length() == i){
                String t = result.removeFirst();
                for(char c : mapping[x].toCharArray()){
                    result.addLast(t+c);
                }
            }
        }
        return result;
    }
}
