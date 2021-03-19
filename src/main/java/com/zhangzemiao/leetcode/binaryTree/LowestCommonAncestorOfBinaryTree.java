package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: lowest common ancestor of binary tree
 * @author: wzhang
 * @date: 2021/3/19
 */
public class LowestCommonAncestorOfBinaryTree {

    static TreeNode result;

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        t1.left = t2;
        t1.right =t3;

        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        t2.left = t4;
        t2.right = t5;

        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        t3.left = t6;
        t3.right = t7;

        t4.left = null;
        t4.right = null;

        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);
        t5.left = t8;
        t5.right = t9;

        System.out.println(lowestCommonAncestor(t1, t2, t9).val);

    }

    public static TreeNode lowestCommonAncestorBest(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        //如果当前根节点就是其中之一,直接返回
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        //遍历左子树
        TreeNode left = lowestCommonAncestorBest(root.left, p, q);
        //遍历右子树
        TreeNode right = lowestCommonAncestorBest(root.right, p, q);
        //如果左子树和右子树都包含其中一个结点，怎当前树是最小祖先
        if(left != null && right != null){
            return root;
        }
        //如果只是左子树匹配到
        if(left != null){
            return left;
        }
        //如果只是右子树匹配到
        if(right != null){
            return right;
        }
        //都没有匹配到
        return null;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        traversalTree(root, p, q);
        return result;
    }

    public static List<Integer> traversalTree(TreeNode root, TreeNode p, TreeNode q){
        //traversal left tree
        List<Integer> leftValues = new ArrayList<>();
        if(root.left != null){
            leftValues = traversalTree(root.left, p, q);
            if(leftValues.contains(p.val) && leftValues.contains(q.val) && result == null){
                result = root.left;
            }
        }
        //traversal right tree
        List<Integer> rightValues = new ArrayList<>();
        if(root.right != null){
            rightValues = traversalTree(root.right, p, q);
            if(rightValues.contains(p.val) && rightValues.contains(q.val) && result == null){
                result = root.right;
            }
        }

        //current tree
        List<Integer> values = new ArrayList<>();
        values.addAll(leftValues);
        values.addAll(rightValues);
        values.add(root.val);
        if(values.contains(p.val) && values.contains(q.val) && result == null){
            result = root;
        }
        return values;
    }

    public static TreeNode traversalPostorder(List<Integer> values,
            TreeNode root, TreeNode p, TreeNode q){
        if(root.left != null){
            TreeNode rs = traversalPostorder(values, root.left, p, q);
            if(rs != null){
                return rs;
            }
        }
        if(root.right != null){
            TreeNode rs = traversalPostorder(values, root.right, p, q);
            if(rs != null){
                return rs;
            }
        }
        //root
        values.add(root.val);
        if(values.contains(p.val) && values.contains(q.val)){
            return root;
        }
        return null;
    }
}
