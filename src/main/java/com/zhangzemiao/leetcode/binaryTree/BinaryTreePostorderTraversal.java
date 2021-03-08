package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: binary tree postorder traversal
 * @author: wzhang
 * @date: 2021/3/8
 */
public class BinaryTreePostorderTraversal {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] arg){

    }

    private static List<Integer> postorderTraversal(TreeNode root){
        if(root == null){
            return result;
        }
        if(root.left != null){
            postorderTraversal(root.left);
        }
        if(root.right != null){
            postorderTraversal(root.right);
        }
        result.add(root.val);
        return result;
    }
}
