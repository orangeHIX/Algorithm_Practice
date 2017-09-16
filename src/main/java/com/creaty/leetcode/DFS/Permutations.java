package com.creaty.leetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hyx on 2017/9/11.
 */
public class Permutations {

    List<List<Integer>> result;

    private List<Integer> asList(int[] nums){
        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < nums.length; index++)
        {
            intList.add(nums[index]);
        }
        return intList;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void permutaion(int[] nums, int start){
        if(start >= nums.length){
            result.add(asList(nums));
        }else{
            for(int i = start; i < nums.length; i++){
                swap(nums, start, i);
                permutaion(nums, start+1);
                swap(nums, start, i);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        permutaion(nums, 0);
        return result;
    }

}
