package com.creaty.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * ?Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)<br/>
 * ?The solution set must not contain duplicate triplets.<br/>
 * <p>
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p>
 * A solution set is:<br/>
 * (-1, 0, 1)<br/>
 * (-1, -1, 2)<br/>
 * <p>
 * <p>
 * Created by hyx on 2015/11/5.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        int sum;
        for (int k = 0; k < nums.length - 2; k++) {
            if (k == 0 || (k > 0 && nums[k] != nums[k - 1])) {
                int i = k + 1, j = nums.length - 1;
                int target = 0 - nums[k];
                while (i < j) {
                    sum = nums[i] + nums[j];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[i + 1]) i++;
                        while (i < j && nums[j - 1] == nums[j]) j--;
                        i++;
                        j--;
                    } else if (sum > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //int target = 9;
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
