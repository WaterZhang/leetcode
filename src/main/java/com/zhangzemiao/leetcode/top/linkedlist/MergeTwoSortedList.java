package com.zhangzemiao.leetcode.top.linkedlist;

/**
 * @Desc: merge two sorted linked list
 * @author: wzhang
 * @date: 2021/1/27
 */
public class MergeTwoSortedList {

    public static void main(String[] args){
//        ListNode l1 = new ListNode(-2);
//        ListNode second = new ListNode(2);
//        ListNode three = new ListNode(4);
//        l1.next = second;
//        second.next = three;

        ListNode l1 = new ListNode(-2);
        ListNode two = new ListNode(5);
        l1.next = two;
        ListNode current = l1;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }

        System.out.println("");
        System.out.println("************");
        System.out.println("");

        ListNode l2 = new ListNode(-9);
        ListNode three2 = new ListNode(-6);
        ListNode four = new ListNode(-3);
        ListNode five = new ListNode(-1);
        ListNode six = new ListNode(1);
        ListNode seven = new ListNode(6);
        l2.next = three2;
        three2.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

//        ListNode three2 = new ListNode(3);
//        ListNode four = new ListNode(4);
//        l2.next = three2;
//        three2.next = four;
        current = l2;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }

        System.out.println("");
        System.out.println("************");
        System.out.println("");
        current = mergeTwoLists2(l1,l2);
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }

    /**
     * insert l2 to l1
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        ListNode head = l1;
        while(l2 != null){
            // find right position
            //compare head
            if(l1.val > l2.val){
                ListNode insert = new ListNode(l2.val, l1);
                head = insert;
                l1 = head;
                l2 = l2.next;
                continue;
            }

            // only 1 node
            if(l1.next == null){
                //head don't need to change
                ListNode insert = new ListNode(l2.val, null);
                l1.next = insert;
                l2 = l2.next;
                continue;
            }

            // at least 2 node
            while(l1 != null && l1.next != null){
                // find right position

                if(l1.val <= l2.val && l1.next.val > l2.val){
                    ListNode insert = new ListNode(l2.val, l1.next);
                    l1.next = insert;
                    break;
                }
                l1 = l1.next;
            }

            if(l1 != null && l1.next == null){
                ListNode insert = new ListNode(l2.val , null);
                l1.next = insert;
            }
            // next
            l2 = l2.next;
            l1 = head;
        }
        return head;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        //merge l2 to l1
        ListNode head = l1;
        while(l2 != null){
            while(l1 != null && l1.next != null){
                if(l1.val <= l2.val && l1.next.val > l2.val){
                    ListNode insert = new ListNode(l2.val, l1.next);
                    l1.next = insert;
                    break;
                } else {
                    l1 = l1.next;
                }
            }
            // check last one
            if(l1 != null && l1.next == null){
                if(l1.val <= l2.val){
                    ListNode insert = new ListNode(l2.val, null);
                    l1.next = insert;
                } else {

                }

            }
            l1 = head;
            l2 = l2.next;
        }
        return head;
    }
}
