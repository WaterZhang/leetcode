package com.zhangzemiao.leetcode.top.strings;

import java.util.Arrays;

/**
 * @Desc: Valid Palindrome
 * @author: wzhang
 * @date: 2021/1/18
 */
public class ValidPalindrome {

    public static void main(String[] args){
        //String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s){
        //lower case
        s = s.toLowerCase();
        char s1[] = new char [s.length()];
        char s2[] = new char [s.length()];
        //left to right
        for(int i = 0, index = 0; i < s.length() ; i++){
            if( (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') ||
                    (s.charAt(i) >= '0'  && s.charAt(i) <= '9') ){
                s1[index] = s.charAt(i);
                index++;
            }
        }
        //right to left
        for(int j = s.length()-1, index = 0; j >= 0; j--){
            if((s.charAt(j) <= 'z' && s.charAt(j) >= 'a') ||
                    (s.charAt(j) >= '0'  && s.charAt(j) <= '9')){
                s2[index] = s.charAt(j);
                index++;
            }
        }
        return Arrays.equals(s1, s2);
    }
}
