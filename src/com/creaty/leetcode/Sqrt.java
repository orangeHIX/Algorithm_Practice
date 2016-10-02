package com.creaty.leetcode;

/**
 * Created by hyx on 2015/11/3.
 */
public class Sqrt {
    static double eps = 1e-4;

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

    public float sqrtByNewton(float x) {
        float val = x;//最终
        float last;//保存上一个计算的值
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
    public double sqrtBitManipulation (int x){
        long ans = 0;
        long bit = 1l << 16;
        while(bit > 0) {
            ans |= bit;
            if (ans * ans > x) {
                ans ^= bit;
            }
            bit >>= 1;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        long start;
        long end;
        double result = 0;
        start = System.currentTimeMillis();
        result = sqrt.mySqrt( 2147395599);
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
        result = Math.sqrt( 2147395599);
        end = System.currentTimeMillis();
        System.out.println("" + result + " time: " + (end - start));

        //System.out.println(Math.sqrt(7));
    }
}
