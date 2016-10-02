package com.creaty.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * Created by hyx on 2015/11/5.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        //int[] result = new int[3];
        int minDifference = Integer.MAX_VALUE;
        int sum = 0;
        int result = 0;
        for (int k = 0; k < nums.length - 2; k++) {
            if (k == 0 || (k > 0 && nums[k] != nums[k - 1])) {
                int i = k + 1, j = nums.length - 1;

                while (i < j) {
                    sum = nums[k] + nums[i] + nums[j];

                    if (sum == target) {
//                        result[0] = nums[k];
//                        result[1] = nums[i];
//                        result[2] = nums[j];
//                        System.out.println(Arrays.toString(new int[]{nums[k], nums[i], nums[j]}));
                        return result = sum;
                    } else {
                        if (Math.abs(sum - target) < minDifference) {
                            //System.out.println("difference: " + difference + ", minDifference: " + minDifference);
//                            System.out.println("sum: " + sum + ", minDifference: " + minDifference);
                            minDifference = Math.abs(sum - target);
                            result = sum;
//                            result[0] = nums[k];
//                            result[1] = nums[i];
//                            result[2] = nums[j];
//                            System.out.println(Arrays.toString(new int[]{nums[k], nums[i], nums[j]}));
                        }
                        if (sum > target) {
                            j--;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 0};
        //int target = 9;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, -100));
    }
}
