package com.creaty.interview;

/**
 * 某人饲养了一头 5 岁的母袋鼠，假设袋鼠 4 岁后（ >=4 岁）方可生小袋鼠；而且之后每年必定只生一头小
 * 袋鼠，假设所有生的袋鼠必定是母袋鼠，而且袋鼠 10 岁会死亡且当年不可生育，请问 N 年后，共有多少
 * 袋鼠？利用程序实现，并给出 N=2000 的返回值。
 * Created by hyx on 2016/4/17.
 */
public class Kangaroo {
    public static void main(String[] args) {
        int[] k = new int[2000 + 1];
        int num = 0, lastNum = 1;
        for (int i = 0; i < 2001; i++) {
            num = lastNum;
            for (int j = 4; j < 10; j++) {
                if (i - j < 0) {
                    if (i - j == -5) {
                        k[i] += 1;
                    }
                } else {
                    k[i] += k[i - j];
                }
            }
            num += k[i];
            if (i - 10 < 0) {
                if (i - 10 == -5) {
                    num -= 1;
                }
            } else {
                num -= k[i - 10];
            }
            lastNum = num;
        }
        System.out.print(num);
    }
}
