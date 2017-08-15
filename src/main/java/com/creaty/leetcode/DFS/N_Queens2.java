package com.creaty.leetcode.DFS;

/**
 * Created by hzhuangyixuan on 2017/8/11.
 */
public class N_Queens2 {
    private int count;
    private boolean[] cols;
    private boolean[] d1;   // diagonals \
    private boolean[] d2;   // diagonals /
    private int n;

    private void backtracking(int row){
        if(row == n){
            count++;
            return;
        }
        for(int col = 0; col < n; col ++){
            int id1 = row - col + n-1;
            int id2 = row + col;
            if( cols[col] || d1[id1] || d2[id2] ) continue;
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            backtracking(row+1);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }

    public int totalNQueens(int n) {
        cols = new boolean[n];
        d1 = new boolean[2*n-1];
        d2 = new boolean[2*n-1];
        this.n = n;
        count = 0;
        backtracking(0);
        return count;
    }
}
