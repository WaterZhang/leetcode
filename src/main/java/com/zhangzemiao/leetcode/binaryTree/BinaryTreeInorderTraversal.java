package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: binary tree inorder traversal
 * @author: wzhang
 * @date: 2021/3/8
 */
public class BinaryTreeInorderTraversal {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args){

    }

    public static List<Integer> inorderTraversal(TreeNode root){
        if(root == null){
            return result;
        }
        if(root.left != null){
            inorderTraversal(root.left);
        }
        result.add(root.val);
        if(root.right != null){
            inorderTraversal(root.right);
        }
        return result;
    }
}
