package com.creaty.leetcode.binary_search;

/**
 * Created by hyx on 2016/10/10.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {2};
        int[] b = {};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
//
//        a = new int[]{1, 3};
//        b = new int[]{2};
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
//
//        a = new int[]{1};
//        b = new int[]{2, 3, 4, 5, 6};
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
//
//        a = new int[]{1, 2};
//        b = new int[]{1, 2};
//        //System.out.println(new MedianOfTwoSortedArrays().findKth(a, 0, b, 0, 2));
//        //System.out.println(new MedianOfTwoSortedArrays().findKth(a,0,b,0,3));
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
//
//        a = new int[]{3};
//        b = new int[]{1, 2, 4};
//        //System.out.println(new MedianOfTwoSortedArrays().findKth(a, 0, b, 0, 2));
//        //System.out.println(new MedianOfTwoSortedArrays().findKth(a,0,b,0,3));
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
    }

    public double findKth(int[] a, int ap, int[] b, int bp, int k) {
        int alen = a.length - ap;
        int blen = b.length - bp;
        if (alen > blen)
            return findKth(b, bp, a, ap, k);
        int m = Math.min(alen, k / 2) - 1;
        if (alen == 0) {
            return b[bp + k - 1];
        }
        if (k == 1) {
            return Math.min(a[ap], b[bp]);
        }
        if (a[ap + m] <= b[bp + m]) {
            return findKth(a, ap + m + 1, b, bp, k - m - 1);
        } else {
            return findKth(a, ap, b, bp + m + 1, k - m - 1);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if ((total & 0x1) == 1) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, total / 2)
                    + findKth(nums1, 0, nums2, 0, total / 2 + 1)) / 2;
        }
    }
}
