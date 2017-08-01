package com.creaty.leetcode.binary_search;

/**
 * Created by hzhuangyixuan on 2017/7/31.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int n1 = matrix.length, n2 = 0;
        if (n1 > 0)
            n2 = matrix[0].length;
        else return false;
        int low = 0, high = n1 * n2 - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (matrix[mid / n2][mid % n2] == target) return true;
            else if (matrix[mid / n2][mid % n2] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
