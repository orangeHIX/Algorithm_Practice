package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhuangyixuan on 2017/8/23.
 */
public class CBTInorderPostorderTree {
    private Map<Integer, Integer> hm;
    private TreeNode helper(int[] postorder, int[] inorder, int ps, int pe, int is, int ie){
        if(ps>pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int pos = hm.get(root.val);
        root.left = helper(postorder, inorder, ps, pe+pos-ie-1, is, pos-1);
        root.right = helper(postorder, inorder, pe+pos-ie, pe-1, pos+1, ie);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        hm = new HashMap<>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return helper(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
    }
}
