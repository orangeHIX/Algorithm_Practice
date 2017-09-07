package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 * Created by hyx on 2017/9/7.
 */
public class SumRoottoLeafNumbers {
    public int helper(TreeNode root, int x){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return x*10 + root.val;
        }
        return helper(root.left, x*10 + root.val) + helper(root.right, x*10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}
