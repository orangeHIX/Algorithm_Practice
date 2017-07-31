package com.creaty.leetcode;

import java.util.HashMap;

/**
 * Created by hyx on 2015/11/2.
 */
public class FractiontoRecurringDecimal {

    public static void main(String[] args) {
        FractiontoRecurringDecimal frd = new FractiontoRecurringDecimal();
        System.out.println(frd.fractionToDeciaml(1, 2));
        System.out.println(frd.fractionToDeciaml(2, 1));
        System.out.println(frd.fractionToDeciaml(1, 3));
        System.out.println(frd.fractionToDeciaml(11, 7));
        System.out.println(frd.fractionToDeciaml(-50, 8));
        System.out.println(frd.fractionToDeciaml(-1, -2147483648));
    }

    public String fractionToDeciaml(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        long divider = denominator; //����
        long dividend = numerator; //������

        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Long, Long> remainderMap = new HashMap<>();
        int offset = 0;
        if (numerator < 0 ^ denominator < 0) {
            //System.out.println("+-: "+numerator+","+denominator+","+numerator * denominator);
            stringBuilder.append('-');
            offset++;
            dividend = Math.abs(dividend);
            divider = Math.abs(divider);
        }

        long quotient = dividend / divider;       //��
        long remainder = dividend % divider;      //����
        //System.out.println("" + dividend + ", " + divider + ", " + quotient + ", " + remainder);

        stringBuilder.append(quotient);
        offset += String.valueOf(quotient).length();
        if (remainder != 0) {
            stringBuilder.append('.');
            offset += 1;
        }
        Long index;
        for (long i = 0; remainder != 0; i++) {
            dividend = remainder * 10;
            if ((index = remainderMap.get(dividend)) != null) {
                stringBuilder.insert(index.intValue() + offset, '(');
                stringBuilder.append(')');
                break;
            } else {
                remainderMap.put(dividend, i);
                //System.out.println("" + dividend + ", " + divider);
                quotient = dividend / divider;
                remainder = dividend % divider;
                //System.out.println("" + quotient + ", " + remainder);
                stringBuilder.append(quotient);
            }
        }

        return stringBuilder.toString();
    }
}
