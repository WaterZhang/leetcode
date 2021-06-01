package com.zhangzemiao.leetcode.linkedlist.doubly;

/**
 * @Desc: my linked list
 * @author: wzhang
 * @date: 2021/6/1
 */
public class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(head == null || index+1 > this.length){
            return -1;
        }
        Node cur = head;
        for(int i=0; i < index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val);
        if(head == null){
            this.head = cur;
            this.length++;
            return;
        }
        cur.next = head;
        this.head = cur;
        this.length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = new Node(val);
        if(head == null){
            this.head = cur;
            this.length++;
            return;
        }
        Node current = this.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = cur;
        this.length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node cur = new Node(val);
        if(head == null){
            this.head = cur;
            this.length++;
            return;
        }
        if(index > this.length){
            return;
        }
        Node current = this.head;
        Node prev = null;
        for(int i=0; i < index; i++){
            prev = current;
            current = current.next;
        }
        cur.next = current;
        if(prev == null){
            this.head = cur;
        } else {
            prev.next = cur;
        }
        this.length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(head == null){
            return;
        }
        if(index+1 > this.length){
            return;
        }
        Node current = this.head;
        Node prev = null;
        for(int i=0; i < index; i++){
            prev = current;
            current = current.next;
        }
        if(prev == null){
            this.head = current.next;
        } else {
            prev.next = current.next;
        }
        current = null;
        this.length--;
    }

    public static void main(String[] args){
        /*
        ["addAtHead"]
         [[6]]
         */
        System.out.println("test");
        MyLinkedList myLinkedList = new MyLinkedList();
        //7
        myLinkedList.addAtHead(7);
        // 2 7
        myLinkedList.addAtHead(2);
        // 1 2 7
        myLinkedList.addAtHead(1);
        // 1 2 0 7
        myLinkedList.addAtIndex(3, 0);
        // 1 0 7
        myLinkedList.deleteAtIndex(2);
        // 6 1 0 7
        myLinkedList.addAtHead(6);
        // 6 1 0 7 4
        myLinkedList.addAtTail(4);
        // 4
        System.out.println(myLinkedList.get(4));
        // 4 6 1 0 7 4
        myLinkedList.addAtHead(4);
        // 4 6 1 0 0 7 4
        myLinkedList.addAtIndex(5, 0);
        // 6 4 6 1 0 0 7 4
        myLinkedList.addAtHead(6);
        System.out.println("test");
    }
}
