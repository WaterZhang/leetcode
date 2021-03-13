package com.zhangzemiao.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc: binary tree level order traversal
 * @author: wzhang
 * @date: 2021/3/13
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args){

    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root != null){
            traverseOneLayer(result, Arrays.asList(root));
        }
        return result;
    }

    /**
     *
     * @param result 将递归结果一直传递下去
     * @param nodes 需要遍历的每一层结点
     */
    public static void traverseOneLayer(List<List<Integer>> result,  List<TreeNode> nodes){
        //当需要遍历的结点为空时,递归结束
        if(nodes.isEmpty()){
            return;
        }
        //每层的node value list
        List<Integer> oneLayerResult = new ArrayList<>();
        //计算下一层的所有结点
        List<TreeNode> nextNodes = new ArrayList<>();
        for(TreeNode node : nodes){
            oneLayerResult.add(node.val);
            if(node.left != null){
                nextNodes.add(node.left);
            }
            if(node.right != null){
                nextNodes.add(node.right);
            }
        }

        result.add(oneLayerResult);
        traverseOneLayer(result, nextNodes);
    }

}
