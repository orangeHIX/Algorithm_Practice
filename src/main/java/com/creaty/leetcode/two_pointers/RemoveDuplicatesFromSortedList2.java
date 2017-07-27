package com.creaty.leetcode.two_pointers;

import com.creaty.leetcode.utility.ListNode;

/**
 * Created by hzhuangyixuan on 2017/7/27.
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode p = head;
        ListNode last = fh;
        while(p != null){
            while(p.next != null && p.val == p.next.val) p = p.next;
            if(last.next == p){
                last = last.next;
            }else{
                last.next = p.next;
            }
            p = p.next;
        }
        return fh.next;
    }
}
