package com.zhangzemiao.leetcode.binaryTree;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @Desc: serialize and deserialize binary tree
 * @author: wzhang
 * @date: 2021/3/19
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
        root.right = three;

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        three.left = four;
        three.right = five;


        String serializeStr = serialize(root);
        TreeNode result = deserialize(serializeStr);
        System.out.println("test");
    }


    public static String serialize(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        traverseOneLayer(result, Arrays.asList(root));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < result.size()-1; i++){
            sb.append(result.get(i)+",");
        }
        sb.append(result.get(result.size()-1));
        return sb.toString();
    }

    public static TreeNode deserialize(String data){
        if(data == null){
            return null;
        }
        String[] dataArray = data.split(",");
        List<Integer> result = new ArrayList<>();
        for(String oneStr : dataArray){
            result.add(Integer.parseInt(oneStr));
        }
        TreeNode root = null;
        if(result != null && !result.isEmpty()){
            root = new TreeNode(result.get(0));
        }
        buildTree(result.subList(1, result.size()), Arrays.asList(root));
        return root;
    }

    // cannot use input/output stream
    public static String serializeNo(TreeNode root) {
        //traversal tree
        try {
            List<Integer> result = new ArrayList<>();
            traverseOneLayer(result, Arrays.asList(root));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(result);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException ex){
            //log
            return null;
        }
    }

    public static TreeNode deserializeNo(String s) {
        try{
            byte[] data = Base64.getDecoder().decode(s);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            List o = (List) ois.readObject();
            ois.close();
            List<Integer> result = (List<Integer>)o;
            TreeNode root = null;
            if(result != null && !result.isEmpty()){
                root = new TreeNode(result.get(0));
            }
            buildTree(result.subList(1, result.size()), Arrays.asList(root));
            return root;
        } catch (Exception  ex){
            // log
            return null;
        }
    }

    public static void buildTree(List<Integer> values, List<TreeNode> nodes){
        if(values.isEmpty()){
            return;
        }
        List<TreeNode> nextNodes = new ArrayList<>();
        for(int i=1; i <= nodes.size(); i++){
            TreeNode one = nodes.get(i-1);
            if(values.size() >= 2){
                Integer leftValue = values.remove(0);
                if(leftValue > 0){
                    one.left = new TreeNode(leftValue);
                    nextNodes.add(one.left);
                }
                Integer rightValue = values.remove(0);
                if(rightValue > 0){
                    one.right = new TreeNode(rightValue);
                    nextNodes.add(one.right);
                }
            }
        }
        if(! values.isEmpty()){
            buildTree(values, nextNodes);
        }
    }

    public static void traverseOneLayer(List<Integer> result,  List<TreeNode> nodes){
        if(nodes.isEmpty()){
            return;
        }
        //计算下一层的所有结点
        List<TreeNode> nextNodes = new ArrayList<>();
        int count = 0;
        for(TreeNode node : nodes){
            count++;
            result.add(node.val);
            if(node.val == Integer.MIN_VALUE){
                continue;
            }
            // skip if no child
            if(node.left == null && node.right == null){
                if(count != nodes.size()){
                    nextNodes.add(new TreeNode(Integer.MIN_VALUE));
                    nextNodes.add(new TreeNode(Integer.MIN_VALUE));
                }
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
}
