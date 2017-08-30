package com.creaty.leetcode.DFS;

import com.creaty.leetcode.utility.TreeLinkNode;

/**
 * Created by hzhuangyixuan on 2017/8/30.
 */
public class PopulatingNextRightPointersinEachNode2 {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root == null) return;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        TreeLinkNode head = null;
        while(cur != null){
            while(cur != null){
                if(cur.left != null){
                    if(pre != null){
                        pre.next = cur.left;
                    }else{
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if(cur.right != null){
                    if(pre != null){
                        pre.next = cur.right;
                    }else{
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
    }
}
