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

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode l11 = new TreeNode(-7);
        TreeNode l12 = new TreeNode(-3);
        root.left = l11;
        root.right = l12;

        TreeNode l21 = new TreeNode(-9);
        TreeNode l22 = new TreeNode(-3);
        l12.left = l21;
        l12.right = l22;

        TreeNode l31 = new TreeNode(9);
        l21.left = l31;

        TreeNode l32 = new TreeNode(-7);
        TreeNode l33 = new TreeNode(-4);
        l21.right = l32;
        l22.left = l33;

        TreeNode l41 = new TreeNode(6);
        l31.left = l41;
        TreeNode l42 = new TreeNode(-6);
        l32.left = l42;
        TreeNode l43 = new TreeNode(-6);
        l32.right = l43;



        /*
        TreeNode l51 = new TreeNode(0);
        l41.left = l51;
        TreeNode l52 = new TreeNode(6);
        l41.right = l52;
        TreeNode l53 = new TreeNode(5);
        l42.left = l53;
        TreeNode l54 = new TreeNode(9);
        l43.left = l54;

        TreeNode l61 = new TreeNode(-1);
        l51.right = l61;
        TreeNode l62 = new TreeNode(-4);
        l52.left = l62;
        TreeNode l63 = new TreeNode(-2);
        l54.left = l63;
         */

        /*
        TreeNode root = new TreeNode(1);
        TreeNode l11 = new TreeNode(2);
        root.left = l11;
        TreeNode l21 = new TreeNode(3);
        l11.left = l21;

         */

        String serializeStr = serialize(root);
        System.out.println(serializeStr);
        TreeNode result = deserialize(serializeStr);
        System.out.println("test");
        //System.out.println(Math.pow(2,3));
    }


    public static String serialize(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        traverseOneLayer(result, Arrays.asList(root), 1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < result.size()-1; i++){
            sb.append(result.get(i)+",");
        }
        sb.append(result.get(result.size()-1));
        return sb.toString();
    }

    public static void traverseOneLayer(List<Integer> result,  List<TreeNode> nodes, int n){
        if(nodes.isEmpty()){
            return;
        }
        List<TreeNode> nextNodes = new ArrayList<>();
        int nextCount = (int)Math.pow(2, n);
        boolean allFake = true;
        for(int i = 0; i < nodes.size(); i++){
            TreeNode one = nodes.get(i);
            result.add(one.val);
            //伪造结点
            if(one.val == Integer.MIN_VALUE){
                nextNodes.add(new TreeNode(Integer.MIN_VALUE));
                nextNodes.add(new TreeNode(Integer.MIN_VALUE));
                continue;
            } else {
                if(one.left != null){
                    allFake = false;
                    nextNodes.add(one.left);
                } else {
                    nextNodes.add(new TreeNode(Integer.MIN_VALUE));
                }
                if(one.right != null){
                    allFake = false;
                    nextNodes.add(one.right);
                } else {
                    nextNodes.add(new TreeNode(Integer.MIN_VALUE));
                }
            }
        }
        //如果全都是伪造的,就不用继续递归了
        if(allFake){
            return;
        } else {
            //如果next nodes 不够 nextCount, 补齐
            for(int i = nextNodes.size(); i < nextCount; i++){
                nextNodes.add(new TreeNode(Integer.MIN_VALUE));
            }
            traverseOneLayer(result, nextNodes, n+1);
        }
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
        buildTree(result.subList(1, result.size()), Arrays.asList(root), 1);
        cleanTree(root);
        return root;
    }

    public static void cleanTree(TreeNode root){
        if(root == null){
            return;
        }
        if(root.val == Integer.MIN_VALUE){
            root.left = null;
            root.right = null;
            return;
        }
        if(root.left != null && root.left.val == Integer.MIN_VALUE){
            root.left = null;
        }
        if(root.right != null && root.right.val == Integer.MIN_VALUE){
            root.right = null;
        }
        cleanTree(root.left);
        cleanTree(root.right);
    }


    public static void buildTree(List<Integer> values, List<TreeNode> nodes, int n){
        if(values.isEmpty()){
            return;
        }
        List<TreeNode> nextNodes = new ArrayList<>();
        for(TreeNode oneNode : nodes){
            oneNode.left = new TreeNode(values.remove(0));
            nextNodes.add(oneNode.left);
            oneNode.right = new TreeNode(values.remove(0));
            nextNodes.add(oneNode.right);
        }
        if(!values.isEmpty()){
            buildTree(values, nextNodes, n+1);
        }
    }


    // cannot use input/output stream
    public static String serializeNo(TreeNode root) {
        //traversal tree
        try {
            List<Integer> result = new ArrayList<>();
            traverseOneLayer(result, Arrays.asList(root), 1);
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
            buildTree(result.subList(1, result.size()), Arrays.asList(root), 1);
            return root;
        } catch (Exception  ex){
            // log
            return null;
        }
    }

    public static void buildTreeBad(List<Integer> values, List<TreeNode> nodes, int n){
        if(values.isEmpty()){
            return;
        }
        List<TreeNode> nextNodes = new ArrayList<>();
        int removeCount = 0;
        for(int i=1; i <= nodes.size(); i++){
            TreeNode one = nodes.get(i-1);
            if(values.size() >= 2){
                Integer leftValue = values.remove(0);
                removeCount++;
                if(leftValue > Integer.MIN_VALUE){
                    one.left = new TreeNode(leftValue);
                    nextNodes.add(one.left);
                }
                Integer rightValue = values.remove(0);
                removeCount++;
                if(rightValue > Integer.MIN_VALUE){
                    one.right = new TreeNode(rightValue);
                    nextNodes.add(one.right);
                }
            }
        }
        for(int i = removeCount; i < (int)Math.pow(2, n); i++){
            values.remove(0);
        }
        if(! values.isEmpty() && !nextNodes.isEmpty()){
            buildTree(values, nextNodes, n+1);
        }
    }

    public static void traverseOneLayerBad(List<Integer> result,  List<TreeNode> nodes, int n){
        if(nodes.isEmpty()){
            return;
        }
        //计算下一层的所有结点
        List<TreeNode> nextNodes = new ArrayList<>();
        int count = 0;
        boolean allNegative = true;
        for(TreeNode node : nodes){
            count++;
            result.add(node.val);
            /*
            if(node.val == Integer.MIN_VALUE){
                continue;
            }  */
            // skip if no child
            if(node.left == null && node.right == null){
                if(count != nodes.size()){
                    nextNodes.add(new TreeNode(Integer.MIN_VALUE));
                    nextNodes.add(new TreeNode(Integer.MIN_VALUE));
                }
                continue;
            }
            if(node.left != null){
                allNegative = false;
                nextNodes.add(node.left);
            } else {
                nextNodes.add(new TreeNode(Integer.MIN_VALUE));
            }
            if(node.right != null){
                allNegative = false;
                nextNodes.add(node.right);
            }else {
                nextNodes.add(new TreeNode(Integer.MIN_VALUE));
            }
        }
        if(allNegative){
            return;
        }
        int nextCount = (int) Math.pow(2, n);
        for(int i = nextNodes.size(); i < nextCount; i++){
            nextNodes.add(new TreeNode(Integer.MIN_VALUE));
        }
        traverseOneLayer(result, nextNodes, n+1);
    }
}
