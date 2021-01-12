package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;

/**
 * @Desc: Move zeroes from array
 * @author: wzhang
 * @date: 2021/1/11
 */
public class MoveZeroes {

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums){
        //counts zero
        int zeroCount = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            }
        }

        //move non-zero to front of array
        for(int i=0,j=0; i < nums.length && j < nums.length-zeroCount ; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }

        //move zero to end of array
        for(int i=0; i < zeroCount && zeroCount != nums.length; i++){
            nums[nums.length-1-i] = 0;
        }
    }

}
