package com.creaty.offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by hyx on 2017/9/14.
 */
public class GetLeastNumbers {
    public static Object[] getLeastNumbers(int[] arr, int k){
        if( arr == null || k <= 0 ) return null;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,(i,j)->j-i);
        for(int i = 0; i < k; i++){
            maxHeap.offer(arr[i]);
        }
        for(int i = k; i < arr.length; i++){
            if(arr[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        return maxHeap.toArray();
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4)));
    }
}
