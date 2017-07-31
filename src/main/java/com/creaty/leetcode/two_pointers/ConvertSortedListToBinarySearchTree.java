package com.creaty.leetcode.two_pointers;

import com.creaty.leetcode.utility.ListNode;
import com.creaty.leetcode.utility.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * Created by hzhuangyixuan on 2017/7/28.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail){

        ListNode fast = head, slow = head;
        if(head == tail) return null;
        while(fast!= tail && fast.next!= tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode t = new TreeNode(slow.val);
        t.left = toBST(head, slow);
        t.right = toBST(slow.next, tail);
        return t;
    }
}
