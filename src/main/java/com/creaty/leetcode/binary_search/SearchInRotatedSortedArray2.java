package com.creaty.leetcode.binary_search;

/**
 * Created by hzhuangyixuan on 2017/7/31.
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if(nums.length < 1) return false;
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return true;
            if (nums[low] < nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[low] > nums[mid]){
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }else{
                low++;
            }
        }
        return target == nums[low] ? true : false;
    }
}
