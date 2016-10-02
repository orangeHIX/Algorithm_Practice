package com.creaty.algorithm;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by hyx on 2016/4/13.
 */
public class SortTest {

    @Test
    public void testInsertSort() throws Exception {
        int[] a = {6,  1,  2, 7,  9,  1,  4,  5, 10,  8, -2};
        int[] b = {-2,1,1,2,4,5,6,7,8,9,10};
        Sort.insertSort(a);
        assertArrayEquals(a,b);
    }

    @Test
    public void testMergeSort() throws Exception {
        int[] a = {6,  1,  2, 7,  9,  1,  4,  5, 10,  8, -2};
        int[] b = {-2,1,1,2,4,5,6,7,8,9,10};
        Sort.mergeSort(a);
        assertArrayEquals(a, b);
    }

    @Test
    public void testQuickSort() throws Exception {
        int[] a = {6,  1,  2, 7,  9,  1,  4,  5, 10,  8, -2};
        int[] b = {-2,1,1,2,4,5,6,7,8,9,10};
        Sort.quickSort(a);
        assertArrayEquals(a, b);
    }
}