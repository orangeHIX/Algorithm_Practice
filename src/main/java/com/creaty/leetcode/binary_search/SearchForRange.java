package com.creaty.leetcode.binary_search;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]
 * Created by hzhuangyixuan on 2017/7/28.
 */
public class SearchForRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) return new int[]{-1, -1};
        int[] result = new int[]{-1, -1};
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        if (nums[low] != target) return result;
        else result[0] = low;

        high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2 + 1;
            if (nums[mid] > target) high = mid - 1;
            else low = mid;
        }
        result[1] = high;
        return result;
    }
}
