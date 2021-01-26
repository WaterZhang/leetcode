package com.zhangzemiao.leetcode.top.linkedlist;

/**
 * @Desc: remove nth node from end of list
 * @author: wzhang
 * @date: 2021/1/26
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
        head.next = second;
//        second.next = three;
//        three.next = four;
//        four.next = five;
        ListNode current = head;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
        current = removeNthFromEnd(head, 2);
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n){
        int size = 1;
        ListNode current = head;
        while(current.next != null){
            current = current.next;
            size++;
        }
        if(size == 1){
            return null;
        }
        if(size == n){
            head = head.next;
            return head;
        }
        current = head;
        ListNode prev = null;
        for(int i=1; i <= size - n; i++){
            prev = current;
            current = current.next;
        }
        if(prev != null && current != null){
            prev.next = current.next;
            return head;
        }
        return null;
    }
}
