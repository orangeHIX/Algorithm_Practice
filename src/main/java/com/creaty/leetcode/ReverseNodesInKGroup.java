package com.creaty.leetcode;

import com.creaty.leetcode.utility.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * Created by hzhuangyixuan on 2017/7/26.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while( cur != null && count < k){
            cur = cur.next;
            count++;
        }
        if(count == k){
            cur = reverseKGroup(cur, k);
            while(count > 0){
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
                count--;
            }
            head = cur;
        }
        return head;
    }
}
