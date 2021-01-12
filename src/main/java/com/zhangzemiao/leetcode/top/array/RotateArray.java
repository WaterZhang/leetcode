package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;

/**
 * @Desc: Rotate Array
 * @author: wzhang
 * @date: 2021/1/11
 */
public class RotateArray {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k){
        int count = 0;
        for(int index=0; index < nums.length && count < nums.length; index++){
            int currentIndex = index;
            int currentValue = nums[index];
            do{
                int nextIndex = (currentIndex+k) % nums.length;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = currentValue;
                currentIndex = nextIndex;
                currentValue = nextValue;
                count++;
            } while(index != currentIndex);
        }
    }


}
