package com.creaty.javaclass;

import java.util.ArrayList;
import java.util.List;

/**
 * �ж�0-2000֮���ж��ٸ��������������Щ����
 * Created by hyx on 2015/11/8.
 */
public class PrimeNumberDigger {

    private static boolean isPrimeNumber(ArrayList<Integer> primeNumberTable, int test) {
        int sqrtTestNum = (int) Math.sqrt(test) + 1;
        for (Integer prime : primeNumberTable) {
            if (prime > sqrtTestNum) {
                break;
            } else if (test % prime == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> findAllPrimeNumber(int limit) {
        ArrayList<Integer> primeNumberTable = new ArrayList<>();
        if (limit < 2) {
            return primeNumberTable;
        }
        primeNumberTable.add(2);
        for (int n = 3; n <= limit; n += 2) {
            if (isPrimeNumber(primeNumberTable, n)) {
                primeNumberTable.add(n);
            }
        }
        System.out.println("There are " + primeNumberTable.size() + " prime numbers from 0 to " + limit);
        return primeNumberTable;
    }

    public static void main(String[] args) {
        List<Integer> list = PrimeNumberDigger.findAllPrimeNumber(2000);
        System.out.println(list);
    }
}
