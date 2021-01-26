package com.zhangzemiao.leetcode.top.linkedlist;

/**
 * @Desc: delete node in linked list
 * @author: wzhang
 * @date: 2021/1/25
 */
public class DeleteNodeInLinkedList {

    public static void main(String[] args){
        ListNode head = new ListNode(4);
        ListNode second = new ListNode(5);
        ListNode three = new ListNode(1);
        ListNode end = new ListNode(9);
        head.next = second;
        second.next = three;
        three.next = end;

    }

    private static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
