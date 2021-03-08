package com.zhangzemiao.leetcode.top.trees;

/**
 * @Desc: validate binary search tree
 * @author: wzhang
 * @date: 2021/2/1
 */
public class ValidateBinarySearchTree {
    static Integer prev;

    public static void main(String[] args){
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);

        TreeNode four = new TreeNode(4, three, six);
        TreeNode one = new TreeNode(1);
        TreeNode root = new TreeNode(5, one, four);
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root){
        return validate(root, null, null);
    }

    //中根排序是升序
    private static boolean inorder(TreeNode root){
        if(root == null){
            return true;
        }
        if(!inorder(root.left)){
            return false;
        }
        if(prev != null && root.val <= prev){
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }

    //
    private static boolean validate(TreeNode root, Integer min, Integer max){
        //empty is valid BST
        if(root == null){
            return true;
        }

        if((min != null && root.val <= min) || (max != null && root.val >= max) ){
            return false;
        }

        return validate(root.right, root.val, max) && validate(root.left, min, root.val);
    }

}
