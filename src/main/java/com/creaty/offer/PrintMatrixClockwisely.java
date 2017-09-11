package com.creaty.offer;

/**
 * Created by hyx on 2017/9/8.
 */
public class PrintMatrixClockwisely {

    public static void printMatrixinCircle(int[][] matrix, int rows, int columns, int start){
        int xEnd = columns-start-1;
        int yEnd = rows-start-1;

        for(int i = start; i <= xEnd; i++){
            System.out.print(matrix[start][i] + " ");
        }
        if(start<yEnd) {
            for (int i = start + 1; i <= yEnd; i++) {
                System.out.print(matrix[i][xEnd] + " ");
            }
        }
        if(start < xEnd && start < yEnd) {
            for (int i = xEnd - 1; i >= start; i--) {
                System.out.print(matrix[yEnd][i] + " ");
            }
        }
        if(start <xEnd && start < yEnd-1) {
            for (int i = yEnd - 1; i > start; i--) {
                System.out.print(matrix[i][start] + " ");
            }
        }
    }

    public static void printMatrixClockwisely(int[][] matrix, int rows, int columns){
        if(matrix == null || rows <=0 || columns <= 0) return;
        int start = 0;
        while(start * 2 < rows && start * 2 < columns){
            printMatrixinCircle(matrix,rows,columns,start);
            start++;
        }
    }

    public static void main(String[] args){
        int columns = 4, rows = 1;
        int[][] matrix = new int[rows][];
        for(int i = 0; i < rows; i++){
            matrix[i] = new int[columns];
            for(int j = 0; j < columns; j++){
                matrix[i][j] = i*columns + j;
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        printMatrixClockwisely(matrix,rows,columns);

    }
}
