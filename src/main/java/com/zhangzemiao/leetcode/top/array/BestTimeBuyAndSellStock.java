package com.zhangzemiao.leetcode.top.array;

/**
 * @Desc: BestTimeBuyAndSellStock
 * @author: wzhang
 * @date: 2021/1/11
 */
public class BestTimeBuyAndSellStock {

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices){
        int profit = 0;
        int valley = 0;
        int peak = 0;
        int index=0;
        while(index < prices.length - 1){
            //valley first
            while(index < prices.length-1 && prices[index] >= prices[index+1]){
                index++;
            }
            if(index < prices.length){
                valley = prices[index];
            }

            //peak
            while(index < prices.length-1 && prices[index] <= prices[index+1]){
                index++;
            }

            if(index < prices.length){
                peak = prices[index];
            }
            profit+= peak - valley;
        }
        return profit;
    }

}
