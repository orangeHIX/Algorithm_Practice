package com.creaty.leetcode;

import com.creaty.leetcode.utility.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Created by hyx on 2015/11/19.
 */
public class MaximumDepthBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + (left > right ? left : right);
    }
}
