package com.creaty.leetcode.two_pointers;

import com.creaty.leetcode.utility.ListNode;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Created by hzhuangyixuan on 2017/7/26.
 */
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (ListNode l : lists) {
            if (l != null) minHeap.offer(l);
        }
        while (minHeap.size() > 1) {
            ListNode n = minHeap.poll();
            p.next = n;
            p = p.next;
            if (n.next != null) {
                minHeap.offer(n.next);
            }
        }
        p.next = minHeap.poll();
        return head.next;
    }
}
