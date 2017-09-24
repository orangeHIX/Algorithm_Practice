package com.creaty.leetcode;

import com.creaty.leetcode.utility.LinkedListUtility;
import com.creaty.leetcode.utility.ListNode;

/**
 * Created by hyx on 2017/9/19.
 */
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(0);
        //helper.next = head;

        ListNode pre = helper;
        ListNode cur = head;
        ListNode next = null; //the next node will be inserted
        while(cur != null){
            next = cur.next;
            if(pre.next != null && pre.next.val>=cur.val) pre=helper;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            //pre = helper;
            cur = next;
        }
        return helper.next;
    }

    public static void main(String[] args){
        ListNode head = LinkedListUtility.getListFromArray(new int[]{1});
        head = insertionSortList(head);
        LinkedListUtility.printList(head);
    }
}
