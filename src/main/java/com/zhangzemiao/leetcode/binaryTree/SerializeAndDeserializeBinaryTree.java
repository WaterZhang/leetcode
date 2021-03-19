package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc: serialize and deserialize binary tree
 * @author: wzhang
 * @date: 2021/3/19
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args){
        /*
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        left.left = four;
        left.right = five;

        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        right.left = six;
        right.right = seven;
         */

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.left = two;
        two.left = three;

        List<Integer> result = new ArrayList<>();
        traverseOneLayer(result, Arrays.asList(root));
        System.out.println(result);

//        String serializeStr = serialize(root);
//        TreeNode result = deserialize(serializeStr);
//        System.out.println("test");
    }


    public static String serialize(TreeNode root){
        //traversal tree

        return null;
    }

    public static void traverseOneLayer(List<Integer> result,  List<TreeNode> nodes){
        if(nodes.isEmpty()){
            return;
        }
        //计算下一层的所有结点
        List<TreeNode> nextNodes = new ArrayList<>();
        for(TreeNode node : nodes){
            result.add(node.val);
            // skip if no child
            if(node.left == null && node.right == null){
                continue;
            }
            if(node.left != null){
                nextNodes.add(node.left);
            } else {
                nextNodes.add(new TreeNode(0));
            }
            if(node.right != null){
                nextNodes.add(node.right);
            }else {
                nextNodes.add(new TreeNode(0));
            }
        }
        traverseOneLayer(result, nextNodes);
    }

    public static TreeNode deserialize(String data){
        return null;
    }
}
