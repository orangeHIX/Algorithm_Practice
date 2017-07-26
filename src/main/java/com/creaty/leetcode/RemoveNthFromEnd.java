package com.creaty.leetcode;

import com.creaty.leetcode.utility.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * Created by hzhuangyixuan on 2017/7/26.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode i = head;
        int k = 0;
        while (i.next != null && k != n - 1) {
            i = i.next;
            k++;
        }
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode j = newhead;
        while (i.next != null) {
            i = i.next;
            j = j.next;
        }
        j.next = j.next.next;
        return newhead.next;
    }
}
