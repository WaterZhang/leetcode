package com.zhangzemiao.leetcode.linkedlist.twopointer;

/**
 * @Desc: linked list cycle
 * @author: wzhang
 * @date: 2021/3/25
 */
public class LinkedListCycle2 {

    public static void main(String[] args){
        //test
    }

    public ListNode detectCycle(ListNode head){
        ListNode possible = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){

            }
        }
        return null;
    }
}
