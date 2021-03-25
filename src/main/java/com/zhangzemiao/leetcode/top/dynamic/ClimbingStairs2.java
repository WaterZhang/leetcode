package com.zhangzemiao.leetcode.top.dynamic;

/**
 * @Desc: climbing stairs
 * @author: wzhang
 * @date: 2021/3/25
 */
public class ClimbingStairs2 {

    public static void main(String[] args){
        System.out.println(climbingStairs(6));
        System.out.println("test");
    }

    public static int climbingStairs(int n){
        if(n <= 2){
            return n;
        }

        int oneStepBeforeWays = 2;
        int twoStepBeforeWays = 1;
        int allWays = 0;
        //从 n = 3 开始, 直到当前的n
        for(int i=3; i <= n; i++){
            // n步的ways = n-1的ways+n-2的ways
            allWays = oneStepBeforeWays + twoStepBeforeWays;
            //n-2 -> n-1
            twoStepBeforeWays = oneStepBeforeWays;
            //n-1 -> n
            oneStepBeforeWays = allWays;
        }
        return allWays;
    }

}
