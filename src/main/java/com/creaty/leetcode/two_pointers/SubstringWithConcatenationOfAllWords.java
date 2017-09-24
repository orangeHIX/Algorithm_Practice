package com.creaty.leetcode.two_pointers;

import java.util.*;

/**
 * Created by hyx on 2017/9/22.
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> counts = new HashMap<>();
        for(String word : words){
            if(!counts.containsKey(word)){
                counts.put(word, 1);
            }else{
                counts.put(word, counts.get(word)+1);
            }
        }
        int n = s.length(), num = words.length, len = words[0].length();
        for(int i = 0; i < n - num*len +1; i++){
            Map<String,Integer> seen = new HashMap<>();
            int j = 0;
            for(;j<num;j++){
                String word = s.substring(i+j*len,i+(j+1)*len);
                if(!counts.containsKey(word)) break;
                else{
                    if(!seen.containsKey(word)) seen.put(word,1);
                    else{
                        int seenTimes = seen.get(word)+1;
                        if(seenTimes > counts.get(word)) break;
                        seen.put(word, seen.get(word)+1);
                    }
                }
            }
            if( j == num ) result.add(i);
        }
        return result;
    }
    public List<Integer> findSubstring2(String s, String[] words) {
        int n = s.length();
        List<Integer> reuslt = new ArrayList<>();
        if(words.length < 1) return reuslt;
        int m = words[0].length();
        if(n < m*words.length) return reuslt;
        int last = n - m +1;
        Map<String, Integer> map = new HashMap<>();
        int[][] table = new int[2][words.length];
        int cnt = 0, index = 0;
        for(int i = 0; i < words.length; i++){
            Integer mapped = map.get(words[i]);
            if(mapped == null){
                cnt++;
                map.put(words[i],index);
                mapped = index;
                index++;
            }
            table[0][mapped]++;
        }
        int[] smapping = new int[last];
        for(int i = 0;i < last; i++){
            String sub = s.substring(i,i+m);
            Integer mapped = map.get(sub);
            if(mapped == null){
                smapping[i] = -1;
            }else{
                smapping[i] = mapped;
            }
        }
        for(int i = 0; i <m; i++){
            int curCnt = cnt;
            int low = i, high = i;
            Arrays.fill(table[1], 0);
            while (high < last){
                while(curCnt > 0 && high < last){
                    int target = smapping[high];
                    if(target != -1 && ++table[1][target] == table[0][target]) curCnt--;
                    high+=m;
                }
                while(curCnt == 0 && low < high){
                    int target = smapping[low];
                    if( target != -1 && --table[1][target] == table[0][target]-1){
                        int len = high - low;
                        if(len/m == words.length) reuslt.add(low);
                        curCnt++;
                    }
                    low+=m;
                }
            }
        }
        return reuslt;
    }
}
