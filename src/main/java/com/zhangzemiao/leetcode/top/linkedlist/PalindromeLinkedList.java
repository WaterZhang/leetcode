package com.zhangzemiao.leetcode.top.linkedlist;

/**
 * @Desc: palindrome linked list
 * @author: wzhang
 * @date: 2021/1/31
 */
public class PalindromeLinkedList {

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < 5; i++){
            sb.append(i);
            sb.insert(0, i);
        }

        System.out.println(sb.toString());
        System.out.println(sb.subSequence(0, sb.length() / 2).toString());
        System.out.println(sb.subSequence(sb.length() / 2, sb.length()).toString());
    }

    private boolean isPalindrome2(ListNode head){
        if(head == null){
            return true;
        }
        ListNode tail = reverseList(head);
        while(head != null){
            if(head.val != tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head){
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

    private boolean isPalindrome(ListNode head){
        if(head == null){
            return true;
        }
        final StringBuilder strA = new StringBuilder();
        while(head != null){
            strA.append(head.val);
            strA.insert(0, head.val);
            head = head.next;
        }
        return strA.substring(0, strA.length() / 2).equals(strA.substring(strA.length() / 2, strA.length()));
    }
}
