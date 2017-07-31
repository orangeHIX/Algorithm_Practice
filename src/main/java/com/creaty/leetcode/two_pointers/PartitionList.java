package com.creaty.leetcode.two_pointers;

import com.creaty.leetcode.utility.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * <p>
 * <p>
 * Created by hzhuangyixuan on 2017/7/28.
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode fh = new ListNode(0);
        ListNode ghead = new ListNode(0);
        ListNode p1 = fh, p2 = ghead;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = ghead.next;
        return fh.next;
    }

    public static void main(String[] args) {
        partition(new ListNode(1), 2);
    }
}
