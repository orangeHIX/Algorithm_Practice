package com.creaty.leetcode.two_pointers;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * <p>
 * <p>
 * Created by hzhuangyixuan on 2017/7/27.
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;
        int i = 1, j = 1;
        int count = 1;
        for (; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                count = 1;
                nums[i++] = nums[j];
            } else {
                if (count < 2) {
                    nums[i++] = nums[j];
                    count++;
                }
            }
        }
        return i;
    }
}
