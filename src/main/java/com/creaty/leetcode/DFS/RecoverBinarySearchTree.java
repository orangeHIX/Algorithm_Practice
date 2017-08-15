package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeNode;

/**
 * Created by hzhuangyixuan on 2017/8/14.
 */
public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root){
        traverse(root);
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }

    public void traverse(TreeNode root) {
        if(root == null ) return;
        traverse(root.left);
        if(first == null && pre.val >= root.val){
            first = pre;
        }
        if(first != null && pre.val >= root.val){
            second = root;
        }
        pre = root;
        traverse(root.right);
    }

    /**
     * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。

     2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。

     a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。

     b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。

     3. 重复以上1、2直到当前节点为空。
     * */
    void inorderMorrisTraversal(TreeNode root) {
        TreeNode cur = root, prev = null;
        while (cur != null)
        {
            if (cur.left == null)          // 1.
            {
                System.out.print(cur.val+" ");
                cur = cur.right;
            }
            else
            {
                // find predecessor
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null)   // 2.a)
                {
                    prev.right = cur;
                    cur = cur.left;
                }
                else                       // 2.b)
                {
                    prev.right = null;
                    System.out.print(cur.val+" ");
                    cur = cur.right;
                }
            }
        }
    }
}
