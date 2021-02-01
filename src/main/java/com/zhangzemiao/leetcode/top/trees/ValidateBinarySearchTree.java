package com.zhangzemiao.leetcode.top.trees;

/**
 * @Desc: validate binary search tree
 * @author: wzhang
 * @date: 2021/2/1
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args){
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);

        TreeNode four = new TreeNode(4, three, six);
        TreeNode one = new TreeNode(1);
        TreeNode root = new TreeNode(5, one, four);
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        boolean validLeft = true;
        if(root.left != null){
            if(root.val > root.left.val){
                validLeft = isValidLeftTree(root.left, root.val);
            } else {
                validLeft = false;
            }
        }

        boolean validRight = true;
        if(root.right != null){
            if(root.val < root.right.val){
                validRight = isValidRightTree(root.right, root.val);
            } else {
                validRight = false;
            }
        }

        return validLeft && validRight;
    }

    private static boolean isValidRightTree(TreeNode root, int min){
        boolean validLeft = true;
        if(root.left != null){
            if(root.left.val < root.val && root.left.val > min){
                validLeft = isValidLeftTree(root.left, root.val);
            } else{
                validLeft = false;
            }
        }

        boolean validRight = true;
        if(root.right != null){
            if(root.right.val > root.val){
                validRight = isValidRightTree(root.right, root.val);
            } else {
                validRight = false;
            }
        }

        return validLeft && validRight;
    }

    private static boolean isValidLeftTree(TreeNode root, int max){
        boolean validLeft = true;
        if(root.left != null){
            if(root.val > root.left.val){
                validLeft = isValidLeftTree(root.left, root.val);
            } else {
                validLeft = false;
            }
        }

        boolean validRight = true;
        if(root.right != null){
            if(root.right.val > root.val && root.right.val < max){
                validRight = isValidRightTree(root.right, root.val);
            } else {
                validRight = false;
            }
        }

        return validLeft && validRight;
    }

}
