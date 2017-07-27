package com.creaty.leetcode.two_pointers;

import com.creaty.leetcode.utility.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * Created by hzhuangyixuan on 2017/7/27.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        tail.next = head;
        ListNode cur = head;
        int move = count - k % count;
        for (int i = 0; i < move; i++) {
            tail = tail.next;
            cur = cur.next;
        }
        tail.next = null;
        return cur;
    }
}
