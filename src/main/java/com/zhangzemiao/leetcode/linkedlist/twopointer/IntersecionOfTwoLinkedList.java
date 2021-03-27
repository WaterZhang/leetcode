package com.zhangzemiao.leetcode.linkedlist.twopointer;

/**
 * @Desc: intersection of two linked list
 * @author: wzhang
 * @date: 2021/3/27
 */
public class IntersecionOfTwoLinkedList {

    public static void main(String[] args){
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(1);
        a.next = c;
        b.next = c;
        System.out.println(getIntersectionNodeV3(a,b).val);

    }

    public static ListNode getIntersectionNodeV3(ListNode headA, ListNode headB){
        int lengthA = 0;
        ListNode a = headA;
        while(a != null){
            lengthA++;
            a = a.next;
        }

        int lengthB =0;
        ListNode b = headB;
        while(b != null){
            lengthB++;
            b = b.next;
        }

        a = headA;
        b = headB;
        if(lengthA > lengthB){
            for(int i=0; i < lengthA - lengthB; i++){
                a = a.next;
            }
        } else {
            for(int i=0; i < lengthB - lengthA; i++){
                b = b.next;
            }
        }

        while(a != b){
            a = a.next;
            b = b.next;
        }

        return a;
    }

    /**
     * 时间复杂度不够好
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNodeV2(ListNode headA, ListNode headB){
        ListNode a = headA;
        while(a != null){
            ListNode b = headB;
            while(b != null){
                if(a == b){
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a = headA;
        while(a != null){
            ListNode b = headB;
            while(b != null){
                if(a == b){
                    ListNode a1 = a;
                    ListNode b1 = b;
                    boolean flag = true;
                    while(a1 != null && b1 != null){
                        if(a1 != b1){
                            flag = false;
                        }
                        a1 = a1.next;
                        b1 = b1.next;
                    }
                    if(flag){
                        return a;
                    }
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }

}
