package com.creaty.leetcode;

/**
 * Created by hyx on 2017/9/22.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] used1 = new boolean[9][9], used2 = new boolean[9][9], used3 = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1', k = i/3*3+j/3;
                    if(used1[i][num]  ||
                            used2[j][num]  ||
                            used3[k][num] ) return false;
                    used1[i][num] = true;
                    used2[j][num] = true;
                    used3[k][num] = true;
                }
            }
        }
        return true;
    }
}
