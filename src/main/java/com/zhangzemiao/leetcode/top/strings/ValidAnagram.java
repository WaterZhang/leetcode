package com.zhangzemiao.leetcode.top.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: Valid Anagram
 * @author: wzhang
 * @date: 2021/1/18
 */
public class ValidAnagram {

    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramV2(s, t));
    }

    private static boolean isAnagramV2(String s, String t){
        char ss[] = s.toCharArray();
        char tt[] = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }

    /**
     * Use one Map to compare
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t){
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            if(sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
        }
        for(int j = 0; j < t.length(); j++){
            if(sMap.containsKey(t.charAt(j)) && sMap.get(t.charAt(j)) > 1){
                sMap.put(t.charAt(j), sMap.get(t.charAt(j)) - 1);
            } else if (sMap.containsKey(t.charAt(j)) && sMap.get(t.charAt(j)) == 1){
                sMap.remove(t.charAt(j));
            } else {
                return false;
            }
        }
        return sMap.isEmpty();
    }
}
