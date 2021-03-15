package com.zhangzemiao.leetcode.binaryTree;

import java.util.Arrays;

/**
 * @Desc: construct binary tree from preorder and inorder traversal
 * @author: wzhang
 * @date: 2021/3/15
 */
public class ConstructBinaryTreePreorderInorder {

    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder, inorder);
    }

    /**
     * 构建binary tree, 本身是一个可以递归的过程。左结点可以是叶子，也可以是子树。
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || preorder.length == 0){
            return null;
        }
        //前序遍历的第一个结点是该树的根节点。
        // root node
        int rootValue = preorder[0];

        // root node position in inorder
        int i=0;
        for(; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                break;
            }
        }

        //find left subtree inorder list
        int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, i);
        //find right subtree inorder list
        int[] rightTreeInorder = Arrays.copyOfRange(inorder, i+1, inorder.length);

        //find left subtree preorder list
        int[] leftTreePreorder = Arrays.copyOfRange(preorder, 1, 1+i);
        //find right subtree preorder
        int[] rightTreePreorder = Arrays.copyOfRange(preorder, i+1, preorder.length);

        return new TreeNode(rootValue,
                buildTree(leftTreePreorder, leftTreeInorder),
                buildTree(rightTreePreorder, rightTreeInorder));
    }

}
