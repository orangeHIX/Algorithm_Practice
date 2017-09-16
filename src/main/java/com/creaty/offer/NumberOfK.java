package com.creaty.offer;

/**
 * Created by hyx on 2017/9/16.
 */
public class NumberOfK {

    public static int binaryFirstSearch(int[] arr, int k){
        int s = 0, e = arr.length-1;
        while(s<=e){
            int mid = s + (e - s)/2;
            if(arr[mid] < k){
                s = mid +1;
            }else{
                e = mid - 1;
            }
        }
        if(s <= arr.length && arr[s] == k) return s;
        else return -1;
    }
    public static int binaryLastSearch(int[] arr, int k){
        int s = 0, e = arr.length-1;
        while(s<=e){
            int mid = s + (e - s+1)/2;
            if(arr[mid] <= k){
                s = mid +1;
            }else{
                e = mid - 1;
            }
        }
        if(e >= 0 && arr[e] == k) return e;
        else return -1;
    }

    public static int numberOfK(int[] arr, int k){
        int i = binaryFirstSearch(arr, k);
        int j = binaryLastSearch(arr, k);
        if(i != -1){
            return j-i+1;
        }else return 0;
    }


    public static void main(String[] args){
        int[] arr = {1,2,3,3,3,3,4,5};
        System.out.println(numberOfK(arr, -1));
    }
}
