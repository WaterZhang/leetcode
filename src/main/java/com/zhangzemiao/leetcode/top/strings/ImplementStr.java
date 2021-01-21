package com.zhangzemiao.leetcode.top.strings;

/**
 * @Desc: implement strStr()
 * @author: wzhang
 * @date: 2021/1/20
 */
public class ImplementStr {

    public static void main(String[] args){
        String haystack = "hello";
        String needle = "ll";
        //String haystack = "a";
        //String needle = "a";
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle){
        // only check needle empty string
        if(needle.isEmpty()){
            return 0;
        }
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.length() >= (i + needle.length())){
                    if(haystack.substring(i, i+needle.length()).equalsIgnoreCase(needle)){
                        return i;
                    }
                }

            }
        }
        // -1 if not found
        return -1;
    }
}
