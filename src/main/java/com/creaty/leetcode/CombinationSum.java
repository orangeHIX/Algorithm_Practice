package com.creaty.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * <p>
 * ?All numbers (including target) will be positive integers.
 * ?Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
 * ?The solution set must not contain duplicate combinations.
 * <p>
 * <p>
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 * <p>
 * Created by hyx on 2015/10/16.
 */
public class CombinationSum {
    int[] candidates;
    int target;
    int[] occurrence;
    List<List<Integer>> solutions = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    private void addNumFromCandidates(int index, LinkedList<Integer> set, int sum) {
        if (index < candidates.length) {
            LinkedList<Integer> newSet = new LinkedList<>(set);
            do {
                if (sum == target) {
                    solutions.add(newSet);
                    break;
                }
                addNumFromCandidates(index + 1, newSet, sum);
                newSet.add(candidates[index]);
                sum = sum + candidates[index];
            } while (sum <= target);
        }
    }

    private List<Integer> getResultSet() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j < occurrence[i]; j++) {
                list.add(candidates[i]);
            }
        }
        return list;
    }

    private void addNumFromCandidates(int index, int sum) {
        if (index < candidates.length) {
            int j = 0;
            do {
                if (sum == target) {
                    solutions.add(getResultSet());
                    break;
                }
                addNumFromCandidates(index + 1, sum);
                occurrence[index]++;
                sum = sum + candidates[index];
                j++;
            } while (sum <= target);

            occurrence[index] -= j;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(this.candidates);
        this.target = target;
        occurrence = new int[candidates.length];
        solutions.clear();

        addNumFromCandidates(0, 0);
        return solutions;
    }
}
