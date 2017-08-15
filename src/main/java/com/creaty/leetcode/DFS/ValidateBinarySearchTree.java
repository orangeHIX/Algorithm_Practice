package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
 * Created by hzhuangyixuan on 2017/8/11.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode){
        if( root == null) return true;
        if( minNode != null && root.val <= minNode.val
                || maxNode != null && root.val >= maxNode.val )return false;
        return isValidBST(root.left, minNode, root) && isValidBST(root.right, root, maxNode);
    }

    TreeNode invalidNode = new TreeNode(Integer.MAX_VALUE);

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, null) != invalidNode;
    }

    private TreeNode isValidBST2(TreeNode node, TreeNode prev) {
        if( node == null ) return prev;
        prev = isValidBST2(node.left, prev);
        if( prev != null && node.val <= prev.val ) return invalidNode;
        return isValidBST2(node.right, node);
    }

    public boolean isValidBST3(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val >= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
