package com.creaty.leetcode;

import junit.framework.TestCase;

/**
 * Created by hyx on 2015/11/6.
 */
public class KthLargestElementinArrayTest extends TestCase {

    public void testFindKthLargest() throws Exception {
        int[] nums = new int[]{3,2,1,5,6,4};
        //System.out.println(new KthLargestElementinArray().findKthLargest(nums,2));
        int[] nums2 = new int[]{2,1};
        //System.out.println(new KthLargestElementinArray().findKthLargest(nums,1));
        assertEquals(2, new KthLargestElementinArray().findKthLargest(nums, 2));
        assertEquals(1,new KthLargestElementinArray().findKthLargest(nums2,1));
    }
}