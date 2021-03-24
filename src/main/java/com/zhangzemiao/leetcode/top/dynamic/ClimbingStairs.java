package com.zhangzemiao.leetcode.top.dynamic;

import java.util.Stack;

/**
 * @Desc: climbing stairs
 * @author: wzhang
 * @date: 2021/3/23
 */
public class ClimbingStairs {

    public static void main(String[] args){
        System.out.println(climbStairs(43));
        System.out.println("test");
    }

    public static int climbStairs(int n){
        if(n <= 2){
            return n;
        }
        int possible = 0;
        int steps = 0;
        for(int twoCount=1; n-2*twoCount >= 0; twoCount++){
            int oneCount = n - 2*twoCount;
            steps = oneCount + twoCount;
            // twoCount in steps
            int oneCaseCount = 1;
            for(int i=0; i < twoCount; i++){
                oneCaseCount*=(steps-i);
            }
            possible+=oneCaseCount;
        }
        possible+=1;
        return possible;
    }



    /**
     * 递归,leetcode不通过
     * @param n
     * @return
     */
    public static int climbStairsOld(int n){
        if(n <= 2){
            return n;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

}
