package com.creaty.interview;

import java.util.*;

/**
 * Created by hyx on 2017/9/10.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        Set<Integer> conflict = new HashSet<>();
        List<List<Integer>> bracelet = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            int size = sc.nextInt();
            List<Integer> s = new ArrayList<>(size);
            for(int j = 0; j < size; j++){
                s.add(sc.nextInt());
            }
            bracelet.add(s);
        }
        int i = 0;
        while( i < n){
            Set<Integer> re = new HashSet<>();
            int count = 0;
            while(count < m) {
                for (Integer e : bracelet.get( (i+count)%n  )) {
                    if (re.contains(e)) {
                        conflict.add(e);
                    } else {
                        re.add(e);
                    }
                }
                count++;
            }
            i++;
        }

        System.out.println(conflict.size());
    }
}
