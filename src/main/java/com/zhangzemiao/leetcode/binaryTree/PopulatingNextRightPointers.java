package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc: populating next right pointers in each node
 * @author: wzhang
 * @date: 2021/3/19
 */
public class PopulatingNextRightPointers {

    public static void main(String[] args){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.left = two;
        one.right = three;

        Node four = new Node(4);
        Node five = new Node(5);
        two.left = four;
        two.right = five;

        Node six = new Node(6);
        Node seven = new Node(7);
        three.left = six;
        three.right = seven;

        connect(one);
        System.out.println("test");
    }

    public static Node connect(Node root){
        if(root != null){
            traverseOneLayer(Arrays.asList(root));
        }
        return root;
    }

    public static void traverseOneLayer(List<Node> nodes){
        if(nodes.isEmpty()){
            return;
        }
        //set next in one layer
        for(int i=0,j=1; j < nodes.size(); i++,j++){
            nodes.get(i).next = nodes.get(i+1);
        }

        //calculate new layer nodes
        List<Node> child = new ArrayList<>();
        for(Node one : nodes){
            if(one.left != null){
                child.add(one.left);
            }
            if(one.right != null){
                child.add(one.right);
            }
        }
        traverseOneLayer(child);
    }
}
