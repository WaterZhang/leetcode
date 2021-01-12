package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;

/**
 * @Desc: Contains Duplicate in Array
 * @author: wzhang
 * @date: 2021/1/11
 */
public class ContainsDuplicate {

    public static void main(String[] args){
        int[] nums = {1,1,2,3};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums){
        Arrays.sort(nums);
        for(int i=0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
