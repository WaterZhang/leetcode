package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;

/**
 * @Desc: Single Number
 * @author: wzhang
 * @date: 2021/1/11
 */
public class SingleNumber {

    public static void main(String[] args){
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums){
        Arrays.sort(nums);

        //first one as default
        int single = nums[0];

        //last element will jump out from for each
        for(int i=0; i< nums.length-1; i++){
            //happy path
            if(nums[i] == nums[i+1]){
                ++i;
            } else {
                return nums[i];
            }

            //single one in end of sorted array
            // 1 1 2 2 5
            if(i == nums.length - 2){
                return nums[nums.length-1];
            }
        }
        return single;
    }

}
