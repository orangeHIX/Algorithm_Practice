package com.creaty.leetcode;

import java.util.*;

/**
 * Created by hyx on 2017/9/24.
 */
public class Permutations2 {
    private List<List<Integer>> result;
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private List<Integer> asList(int[] ints){
        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < ints.length; index++)
        {
            intList.add(ints[index]);
        }
        return intList;
    }
    public void recursion(int[] nums, int i){
        if(i == nums.length - 1){
            result.add(asList(nums));
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for(int k = i; k < nums.length; k++){
            if(appeared.add(nums[k])) {
                swap(nums, i, k);
                recursion(nums, i + 1);
                swap(nums, i, k);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        recursion(nums, 0);
        return result;
    }
}
