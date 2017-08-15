package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeNode;

/**
 * Created by hzhuangyixuan on 2017/8/14.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if( p == null && q == null )return true;
        else if(p != null && q != null ){
            if(p.val != q.val) return false;
            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }else{
            return false;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }
}
