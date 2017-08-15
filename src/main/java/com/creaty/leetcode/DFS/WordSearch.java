package com.creaty.leetcode.DFS;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 * Created by hzhuangyixuan on 2017/8/11.
 */
public class WordSearch {
    int m, n;
    char[][] board;
    boolean[][] used;
    String word;

    private boolean backtracking(int i, int j, int k){
        if(k==word.length()) return true;
        if(i < 0|| j < 0|| i >= m || j >= n || used[i][j] ||board[i][j] != word.charAt(k)){
            return false;
        }
        used[i][j] = true;
        if( backtracking(i-1,j,k+1)
                || backtracking(i+1,j,k+1)
                || backtracking(i,j-1,k+1)
                || backtracking(i,j+1,k+1) ){
            return true;
        }
        used[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length < 1 || word==null || word.isEmpty()) return false;
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        this.used = new boolean[m][];
        for(int i = 0; i < board.length; i++){
            this.used[i] = new boolean[n];
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtracking(i,j,0)) return true;
                }
            }
        }
        return false;
    }
}
