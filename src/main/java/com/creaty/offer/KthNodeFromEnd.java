package com.creaty.offer;

import com.creaty.leetcode.utility.LinkedListUtility;
import com.creaty.leetcode.utility.ListNode;

import java.util.List;

/**
 * Created by hyx on 2017/9/8.
 */
public class KthNodeFromEnd {

    public static ListNode findKthtoTail(ListNode head, int k){
        if(k <= 0 || head == null) return null;
        int count = 0;
        ListNode first = head;
        while(count < k){
            if(first == null)   return null;
            first = first.next;
            count++;
        }
        ListNode second = head;
        while(first != null){
            second = second.next;
            first = first.next;
        }
        return second;
    }


    public static void main(String[] args){
        ListNode head = LinkedListUtility.getListFromArray(new int[]{1,2,3,4,5,6,7,8,9,10});
        LinkedListUtility.printList(head);

        System.out.println(findKthtoTail(head, 0));
    }
}
