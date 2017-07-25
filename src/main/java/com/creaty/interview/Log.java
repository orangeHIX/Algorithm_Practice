package com.creaty.interview;

/**
 * Created by hyx on 2016/4/17.
 */
public class Log {

    public static double log(double a) {
        int N = 15;//取前15+1项来估算
        int k, nk;
        double x, xx, y;
        x = (a - 1) / (a + 1);
        xx = x * x;
        nk = 2 * N + 1;
        y = 1.0 / nk;
        for (k = N; k > 0; k--) {
            nk = nk - 2;
            y = 1.0 / nk + xx * y;

        }
        return 2.0 * x * y;

    }

    public static void main(String[] args) {
        System.out.println(log(2) / log(Math.E));
    }
}
