package com.creaty.leetcode.binary_search;

/**
 * Created by hyx on 2015/11/3.
 */
public class Sqrt {
    static double eps = 1e-4;

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        long start;
        long end;
        double result = 0;
        start = System.currentTimeMillis();
        result = sqrt.mySqrt(2147395599);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));

        start = System.currentTimeMillis();
        result = sqrt.InvSqrt(2147395599);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));

        start = System.currentTimeMillis();
        result = sqrt.sqrtByNewton(2147395599);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));

        start = System.currentTimeMillis();
        result = sqrt.sqrtBitManipulation(2147395599);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));

        start = System.currentTimeMillis();
        result = Math.sqrt(2147395599);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));

        //System.out.println(Math.sqrt(7));
    }

    public double mySqrt(int x) {
        double low = 0;
        double high = x;
        double mid = (low + high) / 2.0;
        double last;
        do {
            if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
            last = mid;
            mid = (high + low) / 2.0;
        } while (Math.abs(last - mid) > eps);
        return mid;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int low = 1, high = x;
        while (true) {
            int mid = low + (high - low) / 2;
            if (mid > x / mid) {
                high = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) return mid;
                low = mid + 1;
            }
        }
    }

    public float sqrtByNewton(float x) {
        float val = x;//����
        float last;//������һ�������ֵ
        do {
            last = val;
            val = (val + x / val) / 2;
        } while (Math.abs(val - last) > eps);
        return val;
    }

    public float InvSqrt(float x) {
        float y = x;
        float xhalf = 0.5f * y;
        int i = Float.floatToIntBits(y); // get bits for floating VALUE
        i = 0x5f375a86 - (i >> 1); // gives initial guess y0
        y = Float.intBitsToFloat(i); // convert bits BACK to float
        y = y * (1.5f - xhalf * y * y); // Newton step, repeating increases accuracy
        y = y * (1.5f - xhalf * y * y); // Newton step, repeating increases accuracy
        y = y * (1.5f - xhalf * y * y); // Newton step, repeating increases accuracy
        return 1 / y;
    }

    public double sqrtBitManipulation(int x) {
        long ans = 0;
        long bit = 1l << 16;
        while (bit > 0) {
            ans |= bit;
            if (ans * ans > x) {
                ans ^= bit;
            }
            bit >>= 1;
        }
        return (int) ans;
    }
}
