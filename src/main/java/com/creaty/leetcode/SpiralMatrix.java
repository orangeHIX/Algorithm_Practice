package com.creaty.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyx on 2017/9/25.
 */
public class SpiralMatrix {
    private List<Integer> result;
    private void printMatrixinCircle(int[][] matrix, int rows, int columns, int start){
        int xEnd = columns-start-1;
        int yEnd = rows-start-1;

        for(int i = start; i <= xEnd; i++){
            result.add(matrix[start][i]);
        }
        if(start<yEnd) {
            for (int i = start + 1; i <= yEnd; i++) {
                result.add(matrix[i][xEnd]);
            }
        }
        if(start < xEnd && start < yEnd) {
            for (int i = xEnd - 1; i >= start; i--) {
                result.add(matrix[yEnd][i]);
            }
        }
        if(start <xEnd && start < yEnd-1) {
            for (int i = yEnd - 1; i > start; i--) {
                result.add(matrix[i][start]);
            }
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        result = new ArrayList<>();
        if(matrix == null) return result;
        int rows = matrix.length;
        if(rows < 1) return result;
        int columns = matrix[0].length;
        if(columns < 1) return result;
        int start = 0;
        while(start * 2 < rows && start * 2 < columns){
            printMatrixinCircle(matrix,rows,columns,start);
            start++;
        }
        return result;
    }
}
