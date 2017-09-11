package com.creaty.interview;

import java.util.*;

/**
 * Created by hyx on 2017/9/10.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> check = new HashMap<>();
        for(int i = 1; i <= n; i++){
            int like = sc.nextInt();
            if(!check.containsKey(like)){
                check.put(like, new ArrayList<>());
            }
            check.get(like).add(i);
        }
        int q = sc.nextInt();
        List<Integer> result = new ArrayList<>(q);
        for(int i = 0; i < q; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            if(l<=r && l > 0 && r <= n) {
                List<Integer> users = check.get(k);
                int count = 0;
                for(Integer u : users){
                    if( l <= u ){
                        if( u > r) break;
                        count++;
                    }
                }
                result.add(count);
            }else{
                result.add(0);
            }
        }
        for(int i = 0; i < q; i++){
            System.out.println(result.get(i));
        }
    }
}
