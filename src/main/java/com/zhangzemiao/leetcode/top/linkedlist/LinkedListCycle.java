package com.zhangzemiao.leetcode.top.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: linked list cycle
 * @author: wzhang
 * @date: 2021/1/31
 */
public class LinkedListCycle {

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);
        head.next = two;
        two.next = three;
        three.next = four;
        System.out.println(hasCycle2(head));
    }

    private static boolean hasCycle2(ListNode head){
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(ListNode head){
        Map<ListNode, Integer> list = new HashMap<>();
        while(head != null){
            if(list.containsKey(head)){
                return true;
            } else {
                list.put(head, 1);
            }
            head = head.next;
        }
        return false;
    }
}
