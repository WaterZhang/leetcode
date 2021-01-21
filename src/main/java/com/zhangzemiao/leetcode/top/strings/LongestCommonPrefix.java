package com.zhangzemiao.leetcode.top.strings;

/**
 * @Desc: longest common prefix
 * @author: wzhang
 * @date: 2021/1/21
 */
public class LongestCommonPrefix {

    public static void main(String[] args){
        //String strs[] = {"flower", "flow", "flight"};
        //String strs[] = {};
        //String strs[] = {"", " "};
        //String strs[] = {"dog","racecar","car"};
        String strs[] = {"aaa","aa","aaa"};
        System.out.println(longestCommonPrefixV5(strs));

    }

    // 尝试从最大的开始
    private static String longestCommonPrefixV5(String[] strs){
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        for(int i= strs[0].length(); i >= 0; i--){
            boolean matched = false;
            for(int j=1; j < strs.length; j++){
                if(strs[j].indexOf(strs[0].substring(0,i)) == 0){
                    matched = true;
                    continue;
                } else {
                    matched = false;
                    break;
                }
            }
            if(matched){
                System.out.println(i);
                return strs[0].substring(0,i);
            }
        }
        return "";
    }

    // 我是从0开始, 内存使用还是不太好
    private static String longestCommonPrefixV4(String[] strs){
        if(strs.length == 0){
            return "";
        }
        for(int i=1; i <= strs[0].length(); i++){
            for(int j=1; j < strs.length; j++){
                if(strs[j].indexOf(strs[0].substring(0,i)) == 0){
                    continue;
                } else {
                    return strs[0].substring(0,i-1);
                }
            }
        }
        return strs[0];
    }

    private static String longestCommonPrefixV3(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        for(int i=1; i <= strs[0].length(); i++){
            for(int j=1; j < strs.length; j++){
                if(strs[j].startsWith(strs[0].substring(0,i))){
                    continue;
                } else {
                    return strs[0].substring(0,i-1);
                }
            }
        }
        return strs[0];

    }

    private static String longestCommonPrefixV2(String strs[]){
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        //find min string
        String minLen = strs[0];
        for(int i=1; i < strs.length; i++){
            if(strs[i].length() < minLen.length()){
                minLen = strs[i];
            }
        }
        if(minLen.length() == 0){
            return "";
        }

        for(int index=1; index<= minLen.length(); index++){
            for(int j=0; j < strs.length; j++){
                if(strs[j].startsWith(minLen.substring(0, index))){
                    continue;
                } else {
                    return minLen.substring(0, index-1);
                }
            }
        }
        return minLen;

    }


    //空间使用率不行
    private static String longestCommonPrefix(String strs[]){
        if(strs == null || strs.length == 0){
            return "";
        }

        //find min string
        String minLen = strs[0];
        for(int i=1; i < strs.length; i++){
            if(strs[i].length() < minLen.length()){
                minLen = strs[i];
            }
        }
        //find longest prefix based on min string.
        StringBuilder result = new StringBuilder();
        int j = 0;
        boolean match = true;
        do {
            for(int i = 0; i < strs.length; i++){
                String prefix = "";
                if(j >= minLen.length()-1){
                    prefix = minLen;
                } else {
                    prefix = minLen.substring(0, j+1);
                }
                if(strs[i].startsWith(prefix)){
                    continue;
                } else {
                    match = false;
                    break;
                }
            }
            if(match && minLen.length() > j){
                result.append(minLen.charAt(j));
            }
            j++;
        } while(j < minLen.length() && match);

        return result.toString();
    }
}
