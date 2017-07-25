package com.creaty.practice;

/**
 * Created by hyx on 2016/1/28.
 */
public class Spiral {

    public static int[][] getTwoDimensionalArray(int m, int n) {
        int[][] arr = new int[m][];
        for (int i = 0; i < m; i++) {
            arr[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = i * n + j + 1;
                System.out.print("" + arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr;
    }

    public static void spiral(int m, int n) {
        int[][] arr = getTwoDimensionalArray(m, n);
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        int dir = 0;
        int i = 0, j = 0;
        int min_x = 0, max_x = m - 1;
        int min_y = 0, max_y = n - 1;
        int total = n * m;
        int count = 0;
        while (count < total) {
            System.out.print("" + arr[i][j] + " ");
            count++;

            //move
            i += x[dir];
            j += y[dir];


            if (!(i >= min_x && i <= max_x && j >= min_y && j <= max_y)) { //if run into wall
                //undo move
                i -= x[dir];
                j -= y[dir];

                //change direction
                dir = (dir + 1) % x.length;

                //narrow the field
                if (x[dir] > 0) {
                    min_x += x[dir];
                } else if (x[dir] < 0) {
                    max_x += x[dir];
                } else if (y[dir] > 0) {
                    min_y += y[dir];
                } else if (y[dir] < 0) {
                    max_y += y[dir];
                }

                //move
                i += x[dir];
                j += y[dir];
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        spiral(4, 4);

        spiral(4, 2);

        spiral(0, 1);
    }
}
