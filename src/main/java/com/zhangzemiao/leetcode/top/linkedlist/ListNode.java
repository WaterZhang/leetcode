package com.zhangzemiao.leetcode.top.linkedlist;

/**
 * @Desc: Node
 * @author: wzhang
 * @date: 2021/1/26
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
