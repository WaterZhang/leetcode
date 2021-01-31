package com.zhangzemiao.leetcode.top.trees;

/**
 * @Desc: maximum depth of binary tree
 * @author: wzhang
 * @date: 2021/1/31
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args){

    }

    private static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        if(root.left != null && root.right == null){
            return 1+maxDepth(root.left);
        }

        if(root.right != null && root.left == null){
            return 1+maxDepth(root.right);
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left > right){
            return 1 + left;
        } else {
            return 1 + right;
        }
    }
}
