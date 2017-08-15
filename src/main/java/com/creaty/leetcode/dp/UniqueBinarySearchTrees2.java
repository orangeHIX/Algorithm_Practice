package com.creaty.leetcode.dp;

import com.creaty.leetcode.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * Created by hzhuangyixuan on 2017/8/4.
 */
public class UniqueBinarySearchTrees2 {

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<>();
        if (n == 0) {
            return result[0];
        }
        result[0].add(null);
        for(int i = 1; i < n+1; i++){
            result[i] = new ArrayList<>();
            for(int j = 0; j < i; j++){
                for(TreeNode left : result[j]){
                    for(TreeNode right: result[i-j-1]){
                        TreeNode node = new TreeNode(j + 1);
                        node.left = left;
                        node.right = clone(right, j + 1);
                        result[i].add(node);
                    }
                }
            }
        }
        return result[n];
    }
}
