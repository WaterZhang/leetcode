package com.zhangzemiao.leetcode.binaryTree;

import java.util.Arrays;

/**
 * @Desc: construct binary tree from inorder and postorder traversal
 * @author: wzhang
 * @date: 2021/3/13
 */
public class ConstructBinaryTreeInorderPostorder {

    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
//        int i = 1;
//        System.out.println(Arrays.toString(inorder));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, 0, i)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, i+1, inorder.length)));
        buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder == null || inorder.length == 0){
            return null;
        }
        int rootValue = postorder[postorder.length-1];
        int i=0;
        for(; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                break;
            }
        }
        int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, i);
        int[] rightTreeInorder = Arrays.copyOfRange(inorder, i+1, inorder.length);

        int[] leftTreePostorder = Arrays.copyOfRange(postorder, 0, leftTreeInorder.length);
        int[] rightTreePostorder = Arrays.copyOfRange(postorder, leftTreeInorder.length,
                leftTreeInorder.length +rightTreeInorder.length);

        return new TreeNode(rootValue,
                buildTree(leftTreeInorder, leftTreePostorder),
                buildTree(rightTreeInorder, rightTreePostorder));
    }


    /**
     * 数组是没有null的，紧凑型
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTreeTest(int[] inorder, int[] postorder){
        int rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        int i=0;
        for(; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                break;
            }
        }
        int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, i);
        System.out.println(Arrays.toString(leftTreeInorder));
        int[] rightTreeInorder = Arrays.copyOfRange(inorder, i+1, inorder.length);
        System.out.println(Arrays.toString(rightTreeInorder));

        int[] leftTreePostorder = Arrays.copyOfRange(postorder, 0, leftTreeInorder.length);
        System.out.println(Arrays.toString(leftTreePostorder));
        int[] rightTreePostorder = Arrays.copyOfRange(postorder, leftTreeInorder.length,
                leftTreeInorder.length +rightTreeInorder.length);
        System.out.println(Arrays.toString(rightTreePostorder));
        return null;
    }

}
