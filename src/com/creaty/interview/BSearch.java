package com.creaty.interview;

/**
 * Created by hyx on 2016/4/18.
 */
public class BSearch {

    public static int bSearch(int arr[], int v) {
        int left, right, middle;
        left = 0;
        right = arr.length - 1;
        int k = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (arr[middle] > v) {
                right = middle;
            } else if (arr[middle] < v) {
                left = middle;
            } else {
                return middle;
            }
            System.out.println(++k);
        }
        return -1;
    }

    public static void main(String[] args) {
//        int arr[] = new int[]{2,6,8,10,13,25,36,45,53,76,88,100,127};
//        bSearch(arr,127);

        int i = 300;
        Integer j = new Integer(300);
        System.out.println(i == j);
        System.out.println(j.equals(i));

        //在-128~127 之外的数
        Integer i1 = 200;
        Integer i2 = 200;
        System.out.println("i1==i2: " + (i1 == i2));
        // 在-128~127 之内的数
        Integer i3 = 100;
        Integer i4 = 100;
        System.out.println("i3==i4: " + (i3 == i4));
    }
}
