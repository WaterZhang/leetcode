package com.zhangzemiao.leetcode.linkedlist.classic;

/**
 * @Desc: remove linked list elements
 * @author: wzhang
 * @date: 2021/4/16
 */
public class RemoveLinkedListElements {

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);
        one.next = two;
        two.next = three;
        three.next = four;
    }

    public ListNode removeElements(ListNode head, int val){
        //return empty if list is empty
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            //if current node should delete
            if(current.val == val){
                //if deleted node is not in head
                if(prev != null){
                    prev.next = current.next;
                    current = current.next;
                }
                //if deleted node is in head
                else {
                    //prev don't need to change
                    //reset head node
                    head = current.next;
                    current = head;
                }
            }
            //if current node don't need to delete
            else {
                prev = current;
                current = current.next;

            }
        }
        return head;
    }

}
