package com.zhangzemiao.leetcode.binaryTree;


/**
 * @Desc: Tree Node
 * @author: wzhang
 * @date: 2021/3/8
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){
    }

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
