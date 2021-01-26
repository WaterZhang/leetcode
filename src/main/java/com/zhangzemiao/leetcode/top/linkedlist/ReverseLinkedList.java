package com.zhangzemiao.leetcode.top.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: reverse Linked List
 * @author: wzhang
 * @date: 2021/1/26
 */
public class ReverseLinkedList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = second;
        second.next = three;
        three.next = four;
        four.next = five;
        ListNode current = head;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println("***************");
        current = reverseList3(head);
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }

    private static ListNode reverseList3(ListNode head){
        //empty
        if(head == null){
            return null;
        }
        //only one node
        if(head != null && head.next == null){
            return head;
        }
        ListNode tail = new ListNode(head.val, null);
        while(head != null && head.next != null){
            head = head.next;
            tail = new ListNode(head.val, tail);
        }
        return tail;
    }

    private static ListNode reverseList2(ListNode head){
        ListNode tail = null;
        ListNode newHead = null;
        //only one node
        if(head != null && head.next == null){
            return head;
        }
        while(head != null && head.next != null){
            tail = new ListNode(head.val, tail);
            head = head.next;
            newHead = new ListNode(head.val, tail);
        }
        return newHead;
    }

    private static ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode tail = null;
        ListNode newHead = null;
        if(current != null && current.next == null){
            return current;
        }
        while(current != null && current.next != null){
            tail = new ListNode(current.val, tail);
            current = current.next;
            newHead = new ListNode(current.val, tail);
        }
        return newHead;
    }

}
