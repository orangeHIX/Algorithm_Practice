package com.creaty.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by hyx on 2016/4/13.
 */
public class SortTest {

    @Test
    public void testInsertSort() throws Exception {
        Random ran = new Random();
        int[] a = new int[1024];
        for(int i=0; i < a.length; i++) {
            a[i] = ran.nextInt(2048);
        }
        Sort.insertSort(a);
        assertTrue(isAscending(a));
    }

    @Test
    public void testMergeSort() throws Exception {
        Random ran = new Random();
        int[] a = new int[1024];
        for(int i=0; i < a.length; i++) {
            a[i] = ran.nextInt(2048);
        }
        Sort.mergeSort(a);
        assertTrue(isAscending(a));
    }

    @Test
    public void testQuickSort() throws Exception {
        Random ran = new Random();
        int[] a = new int[1024];
        for(int i=0; i < a.length; i++) {
            a[i] = ran.nextInt(2048);
        }
        Sort.quickSort(a);
        assertTrue(isAscending(a));
    }


    private boolean isAscending(int[] comparables){
        for( int i = 0; i < comparables.length-1; i++){
            if(comparables[i]-comparables[i+1] > 0){
                return false;
            }
        }
        return true;
    }
}