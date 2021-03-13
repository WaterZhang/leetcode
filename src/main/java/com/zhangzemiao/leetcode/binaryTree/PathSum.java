package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: path sum of binary tree
 * @author: wzhang
 * @date: 2021/3/13
 */
public class PathSum {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(-2);
        TreeNode one = new TreeNode(1);
        TreeNode oneOne = new TreeNode(-1);
        one.left = oneOne;

        TreeNode two = new TreeNode(3);
        left.left = one;
        left.right = two;

        TreeNode right = new TreeNode(-3);
        TreeNode three = new TreeNode(1);
        right.left = three;

        root.left = left;
        root.right = right;

        System.out.println(hasPathSum(root, 3));
    }


    public static boolean hasPathSum(TreeNode root, int targetSum){
        return pathSum(0, root, targetSum);
    }

    /**
     * 要遍历出所有叶子结点，需要把已经遍历的路径求和，传递下去
     * @param pathValues
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean pathSum(int pathValues, TreeNode root, int targetSum){
        if(root.left == null && root.right == null){
            return pathValues + root.val == targetSum;
        }
        pathValues+=root.val;
        boolean leftRs = false;
        if(root.left != null){
            leftRs = pathSum(pathValues, root.left, targetSum);
        }
        boolean rightRs = false;
        if(root.right != null){
            rightRs = pathSum(pathValues, root.right, targetSum);
        }
        return leftRs || rightRs;
    }
}
