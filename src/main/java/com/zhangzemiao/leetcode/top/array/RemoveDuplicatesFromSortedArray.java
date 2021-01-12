package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;

/**
 * @Desc: RemoveDuplicatesFromSortedArray
 * @author: wzhang
 * @date: 2021/1/11
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args){
        int[] nums = {0,0,1,2,4,4,5};
        System.out.println(Arrays.toString(Arrays.copyOf(nums, removeDuplicates(nums))));
    }

    private static int removeDuplicates(int[] nums){
        int length = nums.length;
        for(int index = 0; index < length; index++){
            for(int secondIndex = index+1; secondIndex < length; secondIndex++){
                boolean deleteFlag = false;
                //find redundant position
                if(nums[index] == nums[secondIndex]){
                    for(int shiftIndex = secondIndex; shiftIndex < length -1 ; shiftIndex++){
                        nums[shiftIndex] = nums[shiftIndex+1];
                    }
                    //setup flag and reduce length
                    deleteFlag = true;
                    length--;
                }
                if(deleteFlag){
                    //reset for each
                    secondIndex--;
                }
            }
        }
        return length;
    }

}
