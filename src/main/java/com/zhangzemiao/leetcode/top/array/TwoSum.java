package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: Two Sum
 * @author: wzhang
 * @date: 2021/1/11
 */
public class TwoSum {

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int left = target - nums[i];
            if(maps.containsKey(left)){
                int[] result = {maps.get(left), i};
                return result;
            }
            maps.put(nums[i],i);
        }
        int[] empty = {};
        return empty;
    }
}
