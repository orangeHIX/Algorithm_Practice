package com.creaty.leetcode.two_pointers;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * <p>
 * Created by hyx on 2015/11/6.
 */
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {

        if (nums.length < 1)
            return 0;
        int curr = 0;
        //int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++curr] = nums[i];
            }
        }
        return curr + 1;// == 0 ? 1 : place;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2};
        System.out.println(RemoveDuplicatesfromSortedArray.removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }
}
