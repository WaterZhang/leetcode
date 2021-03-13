package com.zhangzemiao.leetcode.binaryTree;

/**
 * @Desc: Symmetric Tree
 * @author: wzhang
 * @date: 2021/3/13
 */
public class SymmetricTree {

    public static void main(String[] args){

    }

    public static boolean isSymmetric(TreeNode root){
        return traversalSubTree(root.left, root.right);
    }

    public static boolean traversalSubTree(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left != null && right == null){
            return false;
        }
        if(left == null && right != null){
            return false;
        }
        if(left.val == right.val){
            return traversalSubTree(left.left, right.right) && traversalSubTree(left.right, right.left);
        } else {
            return false;
        }
    }


}
