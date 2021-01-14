package com.zhangzemiao.leetcode.top.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: First Unique Character in a String
 * @author: wzhang
 * @date: 2021/1/14
 */
public class FirstUniqueCharacterInString {

    public static void main(String[] args){
        final String s = "leetcode";
        System.out.println(firstUniqueChar(s));
    }

    private static int firstUniqueChar(String s){
        Map<Character, Integer> characters = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            if(characters.containsKey(s.charAt(i))){
                characters.put(s.charAt(i), characters.get(s.charAt(i))+1);
            } else {
                characters.put(s.charAt(i), 1);
            }
        }

        for(int i=0; i < s.length(); i++){
            if(characters.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
