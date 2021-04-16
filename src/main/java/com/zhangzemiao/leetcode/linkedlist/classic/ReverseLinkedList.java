package com.zhangzemiao.leetcode.linkedlist.classic;


/**
 * @Desc: reverse linked list
 * @author: wzhang
 * @date: 2021/4/15
 */
public class ReverseLinkedList {

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        ListNode result = reverseListV2(one);
        System.out.println("test");
    }

    public static ListNode reverseListV3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode next = null;
        do{
            // setup next
            next = head.next;
            //reverse
            head.next = prev;

            //move to next
            prev = head;
            head = next;
        }while(head != null);
        return prev;
    }

    public static ListNode reverseListV2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode next = null;
        do{
            // setup next
            next = head.next;
            //reverse
            head.next = prev;

            //move to next
            prev = head;
            head = next;
        }while(head != null);
        return prev;
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        do{
            // setup next
            next = current.next;
            //reverse
            current.next = prev;
            // setup new head
            head = current;

            //move to next
            prev = current;
            current = next;
        }while(current != null);
        return head;
    }
}
