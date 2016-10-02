package com.creaty.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hyx on 2015/10/17.
 */
public class CombinationSum2 {
    int[] candidates;
    int target;
    int[] occurrence;
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
        if (sum == target) {
            solutions.add(getResultSet());
            return;
        }
        if (index < candidates.length && sum < target) {
            occurrence[index]++;
            sum = sum + candidates[index];
            addNumFromCandidates(index + 1, sum);
            occurrence[index]--;
            sum = sum - candidates[index];
            int i = 1;
            while(index+i < candidates.length && candidates[index] == candidates[index + i]){
                i++;
            }
            addNumFromCandidates(index + i, sum);
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

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
