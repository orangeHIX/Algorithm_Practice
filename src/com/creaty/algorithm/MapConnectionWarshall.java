package com.creaty.algorithm;

/**
 * Created by hyx on 2016/5/2.
 */
public class MapConnectionWarshall {

    private static void print(int[][] matrix, int n){
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%d\t",matrix[j][i]);
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    public static void solve(int[][] matrix, int n) {
        print(matrix,n);
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = matrix[i][j] | matrix[i][k] & matrix[k][j];
                }
            }
            print(matrix,n);
        }
    }

    public static int[][] prepare() {
        int matrix[][];
        matrix = new int[4][];
        matrix[0] = new int[]{0, 1, 1, 0};
        matrix[1] = new int[]{0, 0, 1, 0};
        matrix[2] = new int[]{0, 0, 0, 1};
        matrix[3] = new int[]{0, 0, 1, 0};
        return matrix;
    }

    public static void main(String[] args){
        solve(prepare(), 4);
    }

}
