package com.creaty.javaclass.cardgame2;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.RandomAccess;

public class Cards<T> {

    private static Random r;
    private static final int SHUFFLE_THRESHOLD = 5;


    public static void shuffle(List<?> list) {
        if (r == null) {
            r = new Random();
        }
        shuffle(list, r);
    }

    public static void shuffle(List<?> list, Random r) {
        int size = list.size();
        if (size < SHUFFLE_THRESHOLD || list instanceof RandomAccess) {
            for (int i = size; i > 1; i--)
                swap(list, i - 1, r.nextInt(i));
        } else {
            Object arr[] = list.toArray();
            for (int i = size; i > 1; i--)
                swap(arr, i - 1, r.nextInt(i));
            ListIterator it = list.listIterator();
            for (int i = 0; i < arr.length; i++) {
                it.next();
                it.set(arr[i]);
            }
        }


    }

    private static void swap(List<?> list, int i, int j) {
        // TODO Auto-generated method stub
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

}
