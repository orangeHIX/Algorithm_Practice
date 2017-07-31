package com.creaty.leetcode;

import java.util.Arrays;

/**
 * * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * At this time, nums are sorted
 * Created by hyx on 2015/11/5.
 */
public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;
        int i = 0, j = nums.length - 1;
        int sum;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
