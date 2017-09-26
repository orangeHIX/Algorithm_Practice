package com.creaty.leetcode;

/**
 * Created by hyx on 2017/9/24.
 */
public class RotateImage {
    private void reverseSort(int[][] nums, int i, int j){
        if(i >= j) return;
        for(int k = i; k <= i +(j-i)/2; k++){
            swap(nums, k, i + j - k);
        }
    }
    private void swap(int[][] nums, int i, int j){
        int[] temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        reverseSort(matrix, 0, n-1);
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        //rotate(matrix);
    }
}
