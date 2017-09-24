package com.creaty.leetcode.string;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hyx on 2017/9/20.
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] map = {" ", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> list = new LinkedList<>();
        if(digits == null || digits.isEmpty()) return list;
        list.add("");
        for(int i = 0; i < digits.length(); i++){
            int index = digits.charAt(i)-'0';
            int len = list.size();
            for(int k =0; k < len; k++){
                String s = list.removeFirst();
                for(int j = 0; j < map[index].length(); j++){
                    list.addLast(s+map[index].charAt(j));
                }
            }
        }
        return list;
    }
}
