package com.creaty.leetcode;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p>
 * Try to solve it in linear time/space.
 * <p>
 * Return 0 if the array contains less than 2 elements.
 * <p>
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * <p>
 * Created by hyx on 2015/10/27.
 */
public class MaximumGap {
    static int byteLength = 8;

    public int maximumGap(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        byte[] bucket = new byte[Integer.MAX_VALUE / byteLength];
        int min = nums[0];
        int max = nums[0];
        for (int k : nums) {
            bucket[k / byteLength] = (byte) ((1 << (0x7 & k)) | bucket[k / byteLength]);
            if (k > max)
                max = k;
            if (k < min)
                min = k;
        }
        //System.out.println(Arrays.toString(bucket));
        int gap = 0;
        for (int i = min, j = min; j <= max; j++) {
            if ((bucket[j / byteLength] >> (0x7 & j)) == 1) {
                if (j - i > gap) {
                    gap = j - i;
                }
                i = j;
                //System.out.println(""+i+","+j);
            }
        }
        //System.out.println(gap);
        return gap;
    }

    public int maximumGap2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max, min;
        int biger, smaller;
        max = nums[0];
        min = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        biger = max + 1;
        smaller = min - 1;
        int sectionNum = nums.length;
        int sectionLen = (max-min)/sectionNum+1;
        int sectionMin[] = new int[sectionNum];
        int sectionMax[] = new int[sectionNum];
        for (int i = 0; i < sectionNum; i++) {
            sectionMin[i] = biger;
            sectionMax[i] = smaller;
        }

        int i;
        for (int num : nums) {
            i = (num - min) / sectionLen;
            if (sectionMax[i] < num) {
                sectionMax[i] = num;
            }
            if (num < sectionMin[i]) {
                sectionMin[i] = num;
            }
        }
        System.out.println(Arrays.toString(sectionMin));
        System.out.println(Arrays.toString(sectionMax));
        int gap = 0, k = 0;
        int p = min;
        int b;
        while ( k < sectionNum ) {
            b = sectionMin[k];
            if(b == biger) {

            }else {
                if (gap < b - p) {
                    gap = b - p;
                }
                p = sectionMax[k];
            }
            k++;
        }
        System.out.println(gap);
        return gap;
    }

    public static void main(String[] args) {
        new MaximumGap().maximumGap2(new int[]{1,1000000});
    }
}
