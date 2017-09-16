package com.creaty.offer;

import java.util.*;

/**
 * Created by hyx on 2017/9/16.
 */
public class FirstNotRepeatingChar {

    public static char firstNotRepeatingChar(String str){
        if(str == null || str.isEmpty()) return '\0';
        int[] map = new int[256];
        for(int i = 0; i < str.length(); i++){
            map[str.charAt(i)]++;
        }
        for(int i = 0; i < map.length; i++){
            if(map[i] == 1) return (char) i;
        }
        return '\0';
    }

    public static void main(String[] args){
        System.out.println(firstNotRepeatingChar("abaccdeff"));
    }
}
