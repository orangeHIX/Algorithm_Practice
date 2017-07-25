package com.creaty.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Ensure that numbers within the set are sorted in ascending order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * <p>
 * Output:
 * <p>
 * [[1,2,4]]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * <p>
 * Output:
 * <p>
 * [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * <p>
 * Created by hyx on 2015/10/17.
 */
public class CombinationSum3 {
    int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int k;
    int target;
    int[] occurrence;
    int count;
    List<List<Integer>> solutions = new ArrayList<>();

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
        if (sum == target && count == k) {
            solutions.add(getResultSet());
            return;
        }
        if (index < candidates.length && sum < target && count < k) {
            occurrence[index]++;
            sum = sum + candidates[index];
            count++;
            addNumFromCandidates(index + 1, sum);
            occurrence[index]--;
            sum = sum - candidates[index];
            count--;
//            int i = 1;
//            while (index + i < candidates.length && candidates[index] == candidates[index + i]) {
//                i++;
//            }
//            addNumFromCandidates(index + i, sum);
            addNumFromCandidates(index + 1, sum);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        target = n;
        this.occurrence = new int[candidates.length];
        count = 0;
        solutions.clear();

        addNumFromCandidates(0, 0);
        return solutions;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 7));
    }
}
