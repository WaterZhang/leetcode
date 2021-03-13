package com.zhangzemiao.leetcode.binaryTree;

/**
 * @Desc: maximum depth of binary tree
 * @author: wzhang
 * @date: 2021/3/13
 */
public class MaxDepthBinaryTree {

    public static void main(String[] args){

    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1 ;
    }
}
