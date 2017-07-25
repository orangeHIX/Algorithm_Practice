package com.creaty.leetcode;

import com.creaty.leetcode.utility.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Created by hyx on 2015/11/19.
 */
public class MinimunDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 && right == 0)
            return 1;
        else if (left == 0) {
            return 1 + right;
        } else if (right == 0) {
            return 1 + left;
        } else {
            return 1 + (left < right ? left : right);
        }

    }

}
