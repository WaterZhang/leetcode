package com.zhangzemiao.leetcode.linkedlist.classic;

/**
 * @Desc: odd even linked list
 * @author: wzhang
 * @date: 2021/4/17
 */
public class OddEvenLinkedList {

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        //ListNode three = new ListNode(3);
        //ListNode four = new ListNode(4);
        //ListNode five = new ListNode(5);
        //ListNode six = new ListNode(6);
        one.next = two;
        //two.next = three;
        //three.next = four;
        //four.next = five;
        //five.next = six;

        ListNode result = oddEvenListV2(one);
        System.out.println("test");
    }

    public static ListNode oddEvenListV2(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode current = head;
        //find odd end
        ListNode oddEnd = null;
        //find even edd if have
        ListNode evenEnd = null;
        while(current != null && current.next != null && current.next.next != null){
            current = current.next.next;
        }
        oddEnd = current;
        if(oddEnd.next != null){
            evenEnd = oddEnd.next;
        }

        ListNode prev = head;
        ListNode end = oddEnd;
        current = head.next;
        while(current != null){
            ListNode next = current.next;
            prev.next = next;
            end.next = current;
            end = end.next;
            end.next = null;
            if(next != oddEnd && next != null && next.next != null){
                prev = prev.next;
                current = next.next;
            } else {
                current = null;
            }
        }
        end.next = evenEnd;
        return head;
    }

    public static ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        while(odd != null && odd.next != null && odd.next.next != null){
           odd.next = odd.next.next;
           odd = odd.next;
        }

        odd.next = even;

        while(even != null && even.next != null && even.next.next != null){
            even.next = even.next.next;
            even = even.next;
        }

        return head;
    }
}
