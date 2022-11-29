package com.zhangzemiao.leetcode.sorting;

import java.util.Arrays;

public class MinisumOfFourDigit {

    public static int minisum2(int num){
        int []a={ num%10,(num/10)%10,(num/100)%10 , (num/1000)%10};
        Arrays.sort(a);
        return a[0]*10+a[3]+a[1]*10+a[2];
    }

    public static int minisum(int num){
        // find all possible group
        // get 4 digits by asc order
        int[] fourDigits = initialArray(num);
        // find mini sum for all groups and return
        return fourDigits[0]*10+ fourDigits[1]*10 + fourDigits[2] + fourDigits[3] ;
    }

    public static int[] initialArray2(int num){
        int[] result = new int[4];
        for(int i=0; i< result.length; i++){
            result[i] = num % 10;
            num = num/10;
        }
        Arrays.sort(result);
        return result;
    }

    public static int[] initialArray(int num){
        int[] result = new int[4];
        result[0] = num % 10;
        int second = num/10 % 10;
        if(second < result[0]){
            result[1] = result[0];
            result[0] = second;
        } else {
            result[1] = second;
        }
        int third = num/100 % 10;
        if(third < result[0]){
            result[2] = result[1];
            result[1] = result[0];
            result[0] = third;
        } else if (third < result[1]){
            result[2] = result[1];
            result[1] = third;
        } else {
            result[2] = third;
        }

        int forth = num/1000 % 10;
        if(forth < result[0]){
            result[3] = result[2];
            result[2] = result[1];
            result[1] = result[0];
            result[0] = forth;
        } else if (forth < result[1]){
            result[3] = result[2];
            result[2] = result[1];
            result[1] = forth;
        } else if (forth < result[2]){
            result[3] = result[2];
            result[2] = forth;
        } else {
            result[3] = forth;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(minisum(2932));
    }

}
