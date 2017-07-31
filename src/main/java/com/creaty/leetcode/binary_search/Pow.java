package com.creaty.leetcode.binary_search;

/**
 * Created by hyx on 2015/11/5.
 */
public class Pow {

    public static void main(String[] args) {
        Pow pow = new Pow();
        long start;
        long end;
        double result = 0;
        start = System.currentTimeMillis();
        result = pow.myPow(1.00001,
                123456);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));


        start = System.currentTimeMillis();
        result = pow.myPow2(1.00001,
                123456);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));

//        start = System.currentTimeMillis();
//        result = sqrt.InvSqrt(2147395599);
//        end = System.currentTimeMillis();
//        System.out.println("" + result + " time: " + (end - start));
//
//        start = System.currentTimeMillis();
//        result = sqrt.sqrtByNewton(2147395599);
//        end = System.currentTimeMillis();
//        System.out.println("" + result + " time: " + (end - start));
//

        start = System.currentTimeMillis();
        result = Math.pow(1.00001,
                123456);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));

        //System.out.println(Math.sqrt(7));
    }

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double[] power = new double[31];
        //int[] twoPower = new int[32];
        int k = 1;
        double val = x;
        double last = x;
        int i = 0;

        for (; i < power.length; i++) {
            //twoPower[i] = k;
            power[i] = val;
            if ((k = (k << 1)) <= n) {
                last = val;
                val *= val;

            } else {
                break;
            }
        }
        k = k >> 1;
        //System.out.println(Arrays.toString(power));

        int y0 = k;
        //System.out.println(y0);
        while (y0 != n) {
            if ((y0 + (k = k >> 1)) <= n) {
                System.out.println("y0+k: " + (y0 + k));
                i--;
                val *= power[i];
                y0 += k;
            }
        }

        return val;
    }

    double myPow2(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double result = 1;
        for (double f = x; n > 0; n = n >> 1) {
            if ((n & 1) == 1) {
                result *= f;
            }
            f = f * f;
        }
        return result;
    }
}
