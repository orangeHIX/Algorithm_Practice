package com.creaty.offer;

/**
 * Created by hzhuangyixuan on 2017/8/28.
 */
public class FindElementIn2DArray {
    public static boolean find(int[][] arr, int rows, int cols, int target){
        boolean found = false;
        if(arr!= null && rows > 0 && cols > 0){
            int row = 0;
            int col = cols - 1;
            while(row<rows && col > 0){
                if(arr[row*cols][col] == target){
                    found = true;
                    break;
                }else if(arr[row*cols][col] > target){
                    col--;
                }else{
                    row++;
                }
            }
        }
        return found;
    }
    public static void main(String[] args){
        int[][] arr = {{1,2,8,9},{1,4,9,12},{4,7,10,13},{6,8,11,15}};

        System.out.print(find(arr,4,4, 4));
    }
}
