package com.creaty.offer;

/**
 * Created by hyx on 2017/9/14.
 */
public class MoreThanHalfNum {

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int start, int end){
        if(arr == null || start < 0 || end >= arr.length || start >= end) throw new IllegalArgumentException("") ;
        int pivot = arr[end];
        int i = start - 1;
        int j;
        for(j = start; j < end; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1,end);
        return i+1;
    }

    private boolean checkMoreThanHalf(int[] arr, int result){
        int count = 0;
        int half = arr.length>>1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==result) count++;
            if(count > half) return true;
        }
        return false;
    }

    public int moreThanHalfNum(int[] arr){
        int mid = arr.length>>1;
        int start = 0;
        int end = arr.length-1;
        int index = partition(arr,start, end);
        while(index!=mid){
            if(index > mid){
                end = index-1;
                index = partition(arr,start, end);
            }else{
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        int result = arr[mid];
        if(! checkMoreThanHalf(arr, result))
            result = -1;
        return result;
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        MoreThanHalfNum m = new MoreThanHalfNum();
        System.out.println(m.moreThanHalfNum(arr));
    }

}
