package com.creaty.offer;

import com.creaty.leetcode.utility.LinkedListUtility;
import com.creaty.leetcode.utility.ListNode;

/**
 * Created by hyx on 2017/9/16.
 */
public class FirstCommonNodesInLists {

    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2){
        int len1 = getListLength(head1);
        int len2 = getListLength(head2);
        if(len1 < len2){
            return findFirstCommonNode(head1,head2,len2-len1);
        }else{
            return findFirstCommonNode(head2,head1,len1-len2);
        }
    }

    private static ListNode findFirstCommonNode(ListNode shortList, ListNode longList, int lenDiff){
        for(int i = 0; i < lenDiff; i++){
            longList = longList.next;
        }
        while(shortList != longList){
            shortList = shortList.next;
            longList = longList.next;
        }
        return shortList;
    }

    private static int getListLength(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(-1);
        ListNode tail = LinkedListUtility.getListFromArray(new int[]{3,4,5});
        head1.next = tail;
        head2.next = head3;
        head3.next = tail;

        System.out.println(findFirstCommonNode(head2, head1));
        System.out.println(null == null);
    }
}
