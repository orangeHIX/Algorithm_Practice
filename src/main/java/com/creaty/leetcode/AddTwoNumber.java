package com.creaty.leetcode;

import com.creaty.leetcode.utility.ListNode;

/**
 * Created by hzhuangyixuan on 2017/7/25.
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode root = new ListNode(0);
        ListNode d = root;
        while(l1 != null || l2 != null){
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            d.next = new ListNode(sum%10);
            d = d.next;
            sum = sum / 10;
        }
        if(sum == 1)
            d.next = new ListNode(1);
        return root.next;
    }
}
