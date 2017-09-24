package com.creaty.leetcode;

import java.util.Arrays;

/**
 * Created by hyx on 2017/9/22.
 */
public class NextPermutation {
    private void reverseSort(int[] nums, int i, int j){
        if(i >= j) return;
        for(int k = i; k <= i +(j-i)/2; k++){
            swap(nums, k, i + j - k);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2) return;
        int index = n-1;
        while(index>0){
            if(nums[index-1] < nums[index]) break;
            index--;
        }
        if(index == 0){
            reverseSort(nums, 0, n-1);
        }else{
            int val = nums[index-1];
            int j = n-1;
            while(j >= index){
                if(nums[j] > val) break;
                j--;
            }
            swap(nums, index-1, j);
            reverseSort(nums, index, n-1);
        }
    }
}
