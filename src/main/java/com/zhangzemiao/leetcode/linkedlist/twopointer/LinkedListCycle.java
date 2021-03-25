package com.zhangzemiao.leetcode.linkedlist.twopointer;

/**
 * @Desc: linked list cycle
 * @author: wzhang
 * @date: 2021/3/25
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
