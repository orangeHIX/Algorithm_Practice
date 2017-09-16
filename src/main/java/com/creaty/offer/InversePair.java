package com.creaty.offer;

/**
 * Created by hyx on 2017/9/14.
 */
public class InversePair {

    public static int inversePairs(int[] arr, int[] copy, int start, int end){
        if(start == end){
            copy[start] = arr[start];
            return 0;
        }

        int length = (end-start)/2;
        int left = inversePairs(copy, arr, start, start + length);
        int right = inversePairs(copy, arr, start + length+1, end);

        int i = start + length;
        int j = end;
        int copyIndex = end;
        int count = 0;
        while( i >= start && j >= start + length + 1){
            if(arr[i] > arr[j]){
                copy[copyIndex--] = arr[i--];
                count += j -start-length;
            }else{
                copy[copyIndex--] = arr[i--];
            }
        }
        for(;i>=start;--i) copy[copyIndex--] = arr[i];
        for(;j>=start+length+1;--j) copy[copyIndex--] = arr[j];

        return right + left +count;
    }

    public static int inversePairs(int[] arr){
        if(arr == null) return 0;
        int[] copy = new int[arr.length];
        System.arraycopy(arr,0, copy, 0, arr.length);
        int count =  inversePairs(arr, copy,0, arr.length-1);
        return count;
    }

    public static void main(String[] args){
        System.out.println(inversePairs(new int[]{1,3,2}));
    }
}
