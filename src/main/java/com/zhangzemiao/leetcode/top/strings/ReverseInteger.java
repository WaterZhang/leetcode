package com.zhangzemiao.leetcode.top.strings;

/**
 * @Desc: reverse integer
 * @author: wzhang
 * @date: 2021/1/12
 */
public class ReverseInteger {

    public static void main(String[] args){
        int x = 123;
        System.out.println(x);
        System.out.println(reverse1(x));
    }

    private static int reverse1(int x){
        //avoid 0, max value and min value to go through this algrorithms
        if(x == 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE)
            return 0;

        //use array to implement reverse.
        int length = 0;
        int result = 0;
        Long denominator = 10L;
        do{
            if(denominator > Integer.MAX_VALUE){
                denominator = (long)Integer.MAX_VALUE;
            }
            result = x/denominator.intValue();
            denominator*=10;
            length++;
        } while(result != 0);

        int[] nums = new int[length];

        for(int i=0; i< length; i++){
            if(i == 0){
                nums[i] = x%10;
                denominator = 10L;
            } else {
                nums[i] = (x/denominator.intValue()) % 10;
                denominator*=10;
            }
        }

        boolean breakFlag = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < length; i++){
            if(nums[i] == 0 && !breakFlag){
                continue;
            } else {
                if(!breakFlag){
                    sb.append(nums[i]);
                    breakFlag = true;
                } else{
                    sb.append(Math.abs(nums[i]));
                }
            }
        }
        try{
            return Integer.valueOf(sb.toString());
        } catch(Exception ex){
            return 0;
        }
    }

    private static int reverse(int x){
        //avoid 0, max value and min value to go through this algrorithms
        if(x == 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE)
            return 0;

        //use array to implement reverse.
        int length = 0;
        int result = 0;
        Long denominator = 10L;
        do{
            if(denominator > Integer.MAX_VALUE){
                denominator = (long)Integer.MAX_VALUE;
            }
            result = x/denominator.intValue();
            denominator*=10;
            length++;
        } while(result != 0);

        int[] nums = new int[length];

        for(int i=0; i< length; i++){
            if(i == 0){
                nums[i] = x%10;
                denominator = 10L;
            } else {
                nums[i] = (x/denominator.intValue()) % 10;
                denominator*=10;
            }
        }

        boolean breakFlag = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < length; i++){
            if(nums[i] == 0 && !breakFlag){
                continue;
            } else {
                if(!breakFlag){
                    sb.append(nums[i]);
                    breakFlag = true;
                } else{
                    sb.append(Math.abs(nums[i]));
                }
            }
        }
        try{
            return Integer.valueOf(sb.toString());
        } catch(Exception ex){
            return 0;
        }
    }
}
