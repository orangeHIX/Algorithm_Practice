package com.creaty.leetcode.utility;

/**
 * Created by hyx on 2017/9/8.
 */
public class LinkedListUtility {

    public static ListNode getListFromArray(int[] arr){
        ListNode pre = null;
        ListNode cur = null;
        for(int i = arr.length-1; i >= 0; i--){
            cur = new ListNode(arr[i]);
            cur.next = pre;
            pre = cur;
        }
        return cur;
    }


    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
