package com.zhangzemiao.leetcode.linkedlist.classic;

/**
 * @Desc: List
 * @author: wzhang
 * @date: 2021/4/15
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
