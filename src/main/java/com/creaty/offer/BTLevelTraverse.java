package com.creaty.offer;

import com.creaty.leetcode.utility.BinaryTree;
import com.creaty.leetcode.utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hyx on 2017/9/8.
 */
public class BTLevelTraverse {


    public static void levelTraverse(TreeNode treeNode){
        if(treeNode == null) return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            System.out.print(t.val + "\t");
            if(t.left != null) queue.offer(t.left);
            if(t.right != null) queue.offer(t.right);
        }
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        int parent[] = new int[]{1, 5, 5, 2, 2, -1, 3};
        int n = parent.length;
        TreeNode node = tree.createTree(parent, n);
        levelTraverse(node);
    }

}
