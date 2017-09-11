package com.creaty.offer;

/**
 * Created by hyx on 2017/9/8.
 */
public class VerifySequenceOfBST {
    static boolean verifySequenceofBST(int[] arr, int start, int end){
        if(start >= end) return true;
        int root = arr[end];
        int i = start;
        for(; i<end; i++){
            if(arr[i] >root) break;
        }
        for(int j = i;j<end;j++){
            if(arr[j]<root) return false;
        }
        boolean left = verifySequenceofBST(arr,start, i-1);
        boolean right = verifySequenceofBST(arr,i, end-1);
        return left && right;
    }

    public static boolean verifySequenceofBST(int[] arr){
        return verifySequenceofBST(arr,0, arr.length-1);
    }


    public static void main(String[] args){
        int[] arr = new int[]{5,7,6,9,11,10,8};
        int[] arr2 = new int[]{7,4,6,5};
        System.out.print(verifySequenceofBST(arr2));
    }

}
