package com.zhangzemiao.leetcode.top.strings;

import java.util.Arrays;

/**
 * @Desc: reverse string
 * @author: wzhang
 * @date: 2021/1/12
 */
public class ReverseString {

    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        System.out.println(Arrays.toString(s));
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    private static void reverseString(char[] s){
        for(int i=0; i < s.length/2 ; i++){
            if(i != s.length-1-i){
                char exchange = s[s.length-1-i];
                s[s.length-1-i] = s[i];
                s[i] = exchange;
            }
        }
    }
}
