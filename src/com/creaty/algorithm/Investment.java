package com.creaty.algorithm;

/**
 * Created by hyx on 2016/4/13.
 */
public class Investment {

    public static int solve2(int[][] benefit, int maxMoney, int numProject){
        int F[][] = new int[numProject][];
        int sign[][] =  new int[numProject][];

        int max_j = (int)Math.floor(Math.sqrt((double)maxMoney));
        //System.out.println(max_j);

        for (int i = 0; i < numProject; i++) {
            F[i] = new int[maxMoney + 1];
            sign[i] = new int[maxMoney + 1];
        }

        System.out.println("k = 1:");
        for (int j = 0; j <= maxMoney; j++) {
            int k =  (int)Math.floor(Math.sqrt((double)j));
            F[0][j] = benefit[0][k];
            sign[0][j] = k;
            System.out.printf("F_%d(%d) = %d,\n", 1, j, F[0][j]);
        }

        for (int i = 1; i < numProject; i++) {
            System.out.printf("k = %d:\n", i + 1);
            for (int j = 0; j <= maxMoney; j++) {
                System.out.printf("F_%d(%d) = max{ ", i + 1, j);
                int max_F_i_j = Integer.MIN_VALUE;
                for (int k = 0; k*k <= j; k++) {
                    int candidate = benefit[i][k] + F[i - 1][j - k*k];
                    System.out.printf("g_%d(%d) + F_%d(%d),", i + 1, k, i, j - k*k);
                    if (F[i][j] < candidate) {
                        F[i][j] = candidate;
                        sign[i][j] = k;
                        max_F_i_j = candidate;
                    }
                }
                System.out.printf(" } = %d\n", max_F_i_j);
            }
            System.out.println();
        }

        for (int j = 0; j <= maxMoney; j++) {
            for (int i = 0; i < numProject; i++) {
                System.out.printf("%d\t%d\t",F[i][j],sign[i][j]);
            }
            System.out.print('\n');
        }

        return F[numProject - 1][maxMoney];
    }

    public static int[][] prepare2(){
        int benefit[][];
        benefit = new int[3][];
        benefit[0] = new int[]{2, 4, 7, 11};
        benefit[1] = new int[]{5, 10, 16, 20};
        benefit[2] = new int[]{8, 12, 17, 22};
        return benefit;
    }


    public static int solve(int[][] benefit, int maxMoney, int numProject) {
        int F[][] = new int[numProject][];
        for (int i = 0; i < numProject; i++) {
            F[i] = new int[maxMoney + 1];
        }
        for (int i = 0; i <= maxMoney; i++) {
            F[0][i] = benefit[0][i];
        }
        for (int i = 1; i < numProject; i++) {
            for (int j = 0; j <= maxMoney; j++) {
                for (int k = 0; k <= j; k++) {
                    int candidate = benefit[i][k] + F[i - 1][j - k];
                    if (F[i][j] < candidate) {
                        F[i][j] = candidate;
                    }
                }
            }
        }
        return F[numProject - 1][maxMoney];
    }
    public static int[][] prepare(){
        int benefit[][];
        benefit = new int[4][];
        benefit[0] = new int[]{0, 11, 12, 13, 14, 15};
        benefit[1] = new int[]{0, 0, 5, 10, 15, 20};
        benefit[2] = new int[]{0, 2, 10, 30, 32, 40};
        benefit[3] = new int[]{0, 20, 21, 22, 23, 24};
        return benefit;
    }

    public static void main(String[] args) {
        //System.out.println(solve(prepare(),5,4));
        System.out.println(solve2(prepare2(), 10, 3));

    }
}
