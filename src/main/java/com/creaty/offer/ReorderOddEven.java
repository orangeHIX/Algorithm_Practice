package com.creaty.offer;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by hyx on 2017/9/7.
 */
public class ReorderOddEven {

    interface Condition{
        boolean test(int x);
    }

    static void reorder(int[] arr, Condition c){
        if(arr == null || arr.length < 1) return;
        int low = 0, high = arr.length-1;
        while(low<high){
            while(low < high){
                while(low < high && !c.test(arr[low])) low++;
                while(low < high && c.test(arr[high])) high--;
                if(low < high){
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        reorder(arr,x-> (x & 0x01) == 1);
        System.out.println(Arrays.toString(arr));
    }
}
