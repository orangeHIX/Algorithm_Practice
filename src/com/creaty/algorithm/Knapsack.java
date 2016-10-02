package com.creaty.algorithm;

/**
 * Created by hyx on 2016/4/13.
 */
public class Knapsack {

    public static void solve(int v[], int w[], int limit){
        int typeNum = v.length;
        int F[][] = new int[typeNum+1][];
        for(int i = 0; i <= typeNum; i++){
            F[i] = new int[limit+1];
        }
        F[0][limit] = limit/w[0]*v[0];
        for (int i = 1; i <= typeNum; i++){
            for(int j = 1; j <= limit; j++){
                int a = F[i-1][j];
                int b;
                if(j-w[i-1]<0){
                    b = Integer.MIN_VALUE;
                }else {
                    b = F[i][j-w[i-1]]+v[i-1];
                }
                F[i][j] = Math.max(a,b);
            }
        }
        System.out.println(F[typeNum][limit]);
    }

    public static void main(String[] args){
        int v[] = {1,3,5,9};
        int w[] = {2,3,4,7};
        int limit = 10;
        solve(v,w,limit);
    }
}
