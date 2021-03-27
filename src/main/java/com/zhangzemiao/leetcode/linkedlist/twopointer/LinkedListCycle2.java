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
        if(head == null || head.next == null){
            return null;
        }
        boolean hasCycle = false;
        //先判断是否有cycle,但是返回的node不一定是起始结点
        ListNode cycle = hasCycle(head);
        if(cycle == null){
            return null;
        }
        ListNode current = head;
        while(current != cycle){
            ListNode start = cycle.next;
            while(start != cycle){
                if(current == start){
                    return current;
                }
                start = start.next;
            }
            current = current.next;
        }
        return cycle;
    }

    public ListNode hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }
}
