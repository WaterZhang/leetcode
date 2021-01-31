package com.zhangzemiao.leetcode.top.trees;

/**
 * @Desc: Tree Node
 * @author: wzhang
 * @date: 2021/1/31
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
