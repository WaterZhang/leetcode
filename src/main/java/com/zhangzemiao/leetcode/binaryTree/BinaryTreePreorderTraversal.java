package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: binary tree preorder traversal
 * @author: wzhang
 * @date: 2021/3/8
 */
public class BinaryTreePreorderTraversal {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args){

    }

    public static List<Integer> preorderTraversal(TreeNode root){
        if(root == null){
            return result;
        }

        if(root != null){
            result.add(root.val);
        }

        if(root.left != null){
            preorderTraversal(root.left);
        }

        if(root.right != null){
            preorderTraversal(root.right);
        }
        return result;
    }

}
