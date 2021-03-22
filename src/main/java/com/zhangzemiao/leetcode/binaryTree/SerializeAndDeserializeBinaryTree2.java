package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc: serialize and deserialize binary tree
 * @author: wzhang
 * @date: 2021/3/22
 */
public class SerializeAndDeserializeBinaryTree2 {

    private static final String NULL_SYMBOL = "x";
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        /*
        TreeNode root = new TreeNode(1);
        TreeNode l11 = new TreeNode(2);
        root.left = l11;
        TreeNode l21 = new TreeNode(3);
        l11.left = l21;

         */

        /*
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        l1.left = l21;
        TreeNode l22 = new TreeNode(3);
        l1.right = l22;
        TreeNode l31 = new TreeNode(4);
        l22.left = l31;
        TreeNode l32 = new TreeNode(5);
        l22.right = l32;

         */
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        l1.right = l21;
        TreeNode l31 = new TreeNode(3);
        l21.right = l31;
        TreeNode l41 = new TreeNode(4);
        l31.right = l41;
        TreeNode l51 = new TreeNode(5);
        l41.right = l51;

        String nodeString = serialize(l1);
        System.out.println(nodeString);
        TreeNode result = deserialize(nodeString);
        System.out.println("test");
    }

    public static String serialize(TreeNode root){
        if(root == null){
            return "x"+",";
        }
        return root.val+","+serialize(root.left)+serialize(root.right);
    }

    public static TreeNode deserialize(String data){
        String[] nodes = data.split(",");
        List<String> nodesList = new ArrayList<>();
        for(String one : nodes){
            nodesList.add(one);
        }
        TreeNode root = buildTree(nodesList);
        return root;
    }

    public static TreeNode buildTree(List<String> nodes){
        String value = nodes.remove(0);
        if(value.equals("x")){
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(value));
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

}
