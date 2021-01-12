package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;

/**
 * @Desc: Plus One
 * @author: wzhang
 * @date: 2021/1/11
 */
public class PlusOne {

    public static void main(String[] args){
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    private static int[] plusOne(int[] digits){
        //flag for need to increase array length
        boolean increase = false;
        for(int i= digits.length-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]+=1;
                return digits;
            }
            if(digits[i] == 9){
                digits[i] = 0;
                increase = true;
            }
        }
        //
        if(increase){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for(int i=1; i< result.length; i++){
                result[i] = digits[i-1];
            }
            return result;
        }
        return digits;
    }
}
