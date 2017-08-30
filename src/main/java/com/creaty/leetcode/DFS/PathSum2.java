package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 * Created by hzhuangyixuan on 2017/8/28.
 */
public class PathSum2 {
    public void pathSum(TreeNode root, int sum, List<List<Integer>> result, LinkedList<Integer> currentResult){
        if(root==null) return;
        currentResult.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            result.add(new LinkedList(currentResult));
        }else{
            pathSum(root.left, sum-root.val, result, currentResult);
            pathSum(root.right, sum-root.val, result, currentResult);
        }
        currentResult.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<Integer> currentResult = new LinkedList<Integer>();
        pathSum(root,sum,result,currentResult);
        return result;
    }
}
