package com.creaty.leetcode.two_pointers;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining. <br/>
 * <br/>
 * <p>
 * For example, <br/>
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. <br/>
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Created by hyx on 2015/10/10.
 */
public class TrappingRainWater {

    static private int maxIntIndex(int[] array) {
        if (array.length > 0) {
            int max = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > array[max]) {
                    max = i;
                }
            }
            return max;
        } else {
            return -1;
        }
    }

    static public int trap(int[] height) {
        int index = maxIntIndex(height);
        if (index < 0) {
            return 0;
        }

        int maxHeight = height[index];
        int len = height.length;
        int[][] chart = new int[maxHeight][];

        int water = maxHeight * len;
        for (int i = 0; i < maxHeight; i++) {
            chart[i] = new int[len];
            for (int j = 0; j < len; j++) {
                if (height[j] > i) {
                    chart[i][j] = 1;
                    --water;
                }
            }
        }
//        for (int i = 0; i < maxHeight; i++) {
//            System.out.println(Arrays.toString(chart[i]));
//        }
//        System.out.println("water " + water);

        for (int i = maxHeight - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (chart[i][j] == 1) {
                    break;
                } else if (j - 1 < 0 || chart[i][j - 1] == -1) {
                    chart[i][j] = -1;
                    --water;
                }
            }
        }
//        for (int i = 0; i < maxHeight; i++) {
//            System.out.println(Arrays.toString(chart[i]));
//        }
//        System.out.println("water " + water);

        for (int i = maxHeight - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (chart[i][j] == 1) {
                    break;
                } else if (j + 1 >= len || chart[i][j + 1] == -1) {
                    chart[i][j] = -1;
                    --water;
                }
            }
        }
//        for (int i = 0; i < maxHeight; i++) {
//            System.out.println(Arrays.toString(chart[i]));
//        }
//        System.out.println("water " + water);

        return water;
    }

    static public int trap2(int[] height) {

        int[] water = new int[height.length];
        int leftHeightest = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < leftHeightest) {
                water[i] = leftHeightest - height[i];
            } else {
                leftHeightest = height[i];
            }
        }
        int rightHeightest = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] + water[i] > rightHeightest) {
                water[i] = rightHeightest - height[i];
                if (water[i] < 0) {
                    water[i] = 0;
                    rightHeightest = height[i];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += water[i];
        }
        System.out.println(sum);
        return sum;
    }

    static public int trap3(int[] height) {

        int i = 0, j = height.length - 1, sum = 0, h;
        while (i < j) {
            if (height[i] > height[j]) {
                h = height[j--];
                while (i < j && height[j] <= h) {
                    sum += h - height[j];
                    j--;
                }
            } else {
                h = height[i++];
                while (i < j && height[i] <= h) {
                    sum += h - height[i];
                    i++;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}
