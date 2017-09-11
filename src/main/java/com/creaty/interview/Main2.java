package com.creaty.interview;

import java.util.*;

/**
 * Created by hyx on 2017/9/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Map<Integer,Integer>> check = new ArrayList<>(n);

        check.add(new HashMap<>());
        for(int i = 1; i <= n; i++){
            int like = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            map.putAll(check.get(i-1));
            if(map.containsKey(like)){
                map.put(like, map.get(like)+1);
            }else{
                map.put(like, 1);
            }
            check.add(map);
        }
        int q = sc.nextInt();
        List<Integer> result = new ArrayList<>(q);
        for(int i = 0; i < q; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            if(l<=r && l > 0 && r <= n) {
                int pre = check.get(l-1).containsKey(k) ? check.get(l).get(k) : 0;
                int cur = check.get(r).containsKey(k) ? check.get(r).get(k) : 0;
                result.add(cur-pre);
            }else{
                result.add(0);
            }
        }
        for(int i = 0; i < q; i++){
            System.out.println(result.get(i));
        }
    }
}
