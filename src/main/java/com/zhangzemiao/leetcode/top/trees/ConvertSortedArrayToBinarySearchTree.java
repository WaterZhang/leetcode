package com.zhangzemiao.leetcode.top.trees;


import java.util.Arrays;

/**
 * @Desc: convert sorted array to binary search tree
 * @author: wzhang
 * @date: 2021/3/22
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args){
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println("test");
    }

    public static TreeNode sortedArrayToBST(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int rootValue = nums[nums.length/2];
        TreeNode root = new TreeNode(rootValue);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length/2+1, nums.length));
        return root;
    }

}
