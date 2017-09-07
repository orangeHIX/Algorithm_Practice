package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeNode;

/**
 * Created by hyx on 2017/9/7.
 */
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    public int helper(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(0,helper(root.left));
        int rightMax = Math.max(0,helper(root.right));
        max = Math.max(max, leftMax+root.val+rightMax);
        return Math.max(leftMax+root.val, rightMax+root.val);
    }


    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
}
