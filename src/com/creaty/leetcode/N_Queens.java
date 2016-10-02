package com.creaty.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 * Created by hyx on 2015/10/16.
 */
public class N_Queens {

    int n;
    int[] columnOfEachRow;
    List<List<String>> solutions = new ArrayList<>();

    private ArrayList<String> getSolution(){
        ArrayList<String> list  = new ArrayList<>();
        StringBuilder sb;
        for(int i = 0; i < n; i++){
            int column = columnOfEachRow[i];
            sb= new StringBuilder();
            for(int j = 0; j < n; j++){
                if(j == column)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            sb.append('\n');
            list.add(sb.toString());
        }
        return list;
    }

    private boolean test( int row ){
        for(int i = 0; i < row; i++){
            if(row-i == Math.abs(columnOfEachRow[row]-columnOfEachRow[i])
                    || columnOfEachRow[row] == columnOfEachRow[i]){
                return false;
            }
        }
        return true;
    }

    private void placeQueen(int row ){
        if(row >= n ){
            solutions.add(getSolution());
        }else{
            for(int i = 0; i <n; i++){
                columnOfEachRow[row] = i;
                if(test(row)){
                    placeQueen(row + 1);
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        columnOfEachRow = new int[n];
        this.n = n;
        solutions.clear();

        placeQueen(0);

        return solutions;
    }

    public static void main(String[] args){
        N_Queens n_queens = new N_Queens();

        System.out.println(n_queens.solveNQueens(8).size());
    }
}
