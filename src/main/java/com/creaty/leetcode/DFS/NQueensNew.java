package com.creaty.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhuangyixuan on 2017/8/9.
 */
public class NQueensNew {
    private List<String> getSolultion(int[] colOfEachRow, int n){
        List<String> list = new ArrayList<>();
        StringBuilder sb ;
        for(int i = 0; i < n; i++){
            int col = colOfEachRow[i];
            sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(j==col) sb.append('Q');
                else sb.append('.');
            }
            list.add(sb.toString());
        }
        return list;
    }

    private boolean test(int row, int[] colOfEachRow){
        for(int i = 0; i < row; i++){
            if(row-i == Math.abs(colOfEachRow[i]-colOfEachRow[row]) || colOfEachRow[row] == colOfEachRow[i]){
                return false;
            }
        }
        return true;
    }

    private void placeQueen(List<List<String>> solutions,int[] colOfEachRow, int row, int n){
        if( row >= n){
            solutions.add(getSolultion(colOfEachRow, n));
        }else{
            for(int i = 0; i < n; i++){
                colOfEachRow[row] = i;
                if(test(row, colOfEachRow)){
                    placeQueen(solutions, colOfEachRow, row+1, n);
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[] colOfEachRow = new int[n];
        List<List<String>> solutions = new ArrayList<>();
        placeQueen(solutions, colOfEachRow, 0, n);
        return solutions;
    }

    public static void main(String[] args){
        NQueensNew nq = new NQueensNew();
        int n = 8;
        List<List<String>> so = nq.solveNQueens(n);
        for(int i = 0; i < so.size(); i++){
            for(int j = 0; j < n; j++){
                System.out.println(so.get(i).get(j));
            }
            System.out.println();
        }
    }
}
