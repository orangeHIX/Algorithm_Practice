package com.creaty.leetcode.two_pointers;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * Created by hzhuangyixuan on 2017/7/27.
 */
public class SortColor {
    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sortColors(int[] nums) {
        int i = -1, j = nums.length;
        for (int k = 0; k < j; k++) {
            if (nums[k] == 0) exch(nums, k, ++i);
            else if (nums[k] == 2) {
                exch(nums, k, --j);
                k--;
            }
        }
    }
}
