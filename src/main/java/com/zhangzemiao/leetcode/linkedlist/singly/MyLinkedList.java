package com.zhangzemiao.leetcode.linkedlist.singly;

/**
 * @Desc: my linked list
 * @author: wzhang
 * @date: 2021/3/25
 */
public class MyLinkedList {

    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList(){
    }

    public int get(int index){
        if(index < 0 || index >= size){
            return -1;
        }
        Node current = head;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val){
        Node prev = head;
        Node newHead = new Node(val);
        newHead.next = prev;
        head = newHead;
        size++;
    }

    public void addAtTail(int val){
        Node tail = new Node(val);
        if(head == null){
            head = tail;
        } else {
            Node current = head;
            while(current != null){
                current = current.next;
            }
            current.next = tail;
        }
        size++;
    }

    public void addAtIndex(int index, int val){
        if(index >= size){
            return;
        }
        Node newOne = new Node(val);
        Node current = head;
        for(int i=0; i < index-1; i++){
            current = current.next;
        }
        newOne.next = current.next;
        current.next = newOne;
        size++;
    }

    public void deleteAtIndex(int index){
        if(index >= size){
            return;
        }
        if(index == 0){
            head = head.next;
        } else {
            Node current = head;
            for(int i=0; i < index -1; i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }


    public static void main(String[] args){

    }

}
