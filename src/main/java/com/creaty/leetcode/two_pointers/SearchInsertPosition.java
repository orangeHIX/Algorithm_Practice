package com.creaty.leetcode.two_pointers;

/**
 * Created by hyx on 2017/9/22.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] < target) s = mid + 1;
            else e = mid -1;
        }
        return s;
    }
}
