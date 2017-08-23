package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeNode;

/**
 * Created by hzhuangyixuan on 2017/8/15.
 */
public class CBTreePreorderInorderTraversal {
    private TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie){
        if(ps>pe) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int pos = 0;
        for(int i = is; i <= ie; i++){
            if(inorder[i] == root.val){
                pos = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, ps+1, ps+pos-is, is, pos-1);
        root.right = helper(preorder, inorder, ps+pos-is+1, pe, pos+1, ie);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}
