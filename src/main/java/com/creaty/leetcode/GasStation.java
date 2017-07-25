package com.creaty.leetcode;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * Note:
 * The solution is guaranteed to be unique.
 * <p>
 * Created by hyx on 2015/11/1.
 */
public class GasStation {
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;
        for (int i = 0; i < n; i++) {
            tank = 0;
            for (int j = i, index = j; j == i || (index = j % n) != i; j++) {
                tank += (gas[index] - cost[index]);
                if (tank < 0)
                    break;
            }
            if (tank >= 0) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int tank = 0;
        int totalGas = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (totalGas < 0) {
            return -1;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(new int[]{2}, new int[]{1}));
    }
}
