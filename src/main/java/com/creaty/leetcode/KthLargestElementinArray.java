package com.creaty.leetcode;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * <p>
 * Created by hyx on 2015/11/6.
 */
public class KthLargestElementinArray {

    public static void main(String[] args) {
        /* write your code here */
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        //System.out.println(new KthLargestElementinArray().partition(nums, 0, nums.length - 1)+", "+Arrays.toString(nums) );
        System.out.println(new KthLargestElementinArray().findKthLargest(nums, 4));
//        int[] nums2 = new int[]{2, 1};
//        System.out.println(new KthLargestElementinArray().findKthLargest(nums, 1));
    }

    public int partition(int[] nums, int l, int r) {
        int i, j, x, temp;
        i = l;
        j = r;
        x = nums[l];
        while (i < j) {
            while (i < j && nums[j] >= x) j--;
            nums[i] = nums[j];
            //System.out.println("i,j: " +i +","+j +Arrays.toString(nums));
            while (i < j && nums[i] <= x) i++;
            nums[j] = nums[i];
            //System.out.println("i,j: " +i +","+j +Arrays.toString(nums));
        }
        nums[i] = x;
        return i;
    }

    public int findKthLargest(int[] nums, int l, int r, int k) {
        int i;
        if (l == r && l == nums.length - k) //递归结束
        {
            return nums[l];
        }
        i = partition(nums, l, r);//划分
        if (i == nums.length - k) //递归结束，找到第K大的数
            return nums[i];
        else if (nums.length - k < i) {
            return findKthLargest(nums, l, i - 1, k);//递归调用，在前面部分查找第K大的数
        } else {
            return findKthLargest(nums, i + 1, r, k);//递归调用，在后面部分查找第K大的数
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
}
