package com.creaty.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9<br/>
 * Output: index1=1, index2=2
 * <p>
 * Created by hyx on 2015/11/5.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;
        HashMap<Integer, Integer> difference = new HashMap<>();
        Integer index = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((index = difference.get(nums[i])) != null) {
                return new int[]{index + 1, i + 1};
            } else {
                difference.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }
}
