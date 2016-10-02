package com.creaty.leetcode;

import com.creaty.leetcode.utility.TreeNode;

/**
 * Created by hyx on 2015/11/6.
 */
public class BalancedBinaryTree {


    /***
     * @return root树的深度
     */
    public static int getHeightifBalanced(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftHeightifBalanced = getHeightifBalanced(root.left);
            int rightHeightifBalanced = getHeightifBalanced(root.right);
            if (leftHeightifBalanced != -1 && rightHeightifBalanced != -1) {
                if (Math.abs(leftHeightifBalanced - rightHeightifBalanced) < 2) {
                    return 1 + Math.max(leftHeightifBalanced, rightHeightifBalanced);
                }
            }
            return -1;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (getHeightifBalanced(root)>=0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(isBalanced(root));
    }
}
