package com.zhangzemiao.leetcode.top.strings;

import java.lang.module.FindException;

/**
 * @Desc: String to Integer
 * @author: wzhang
 * @date: 2021/1/19
 */
public class StringToInteger {

    public static void main(String[] args){
        //String s = "-91283472332";
        //String s = "words and 987";
        //String s = "     -42";
        //String s = "-+12";
        //String s = "00000-42a1234";
        //String s = "  0000000000012345678";
        //String s = "     +004500";
        String s = "20000000000000000000";
        //String s = "21474836460";
        //String s = "2147483648";
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoiV2(s));
    }

    private static int myAtoiV2(String s){
        int flag = 0;
        boolean zeroFilterFlag = true;
        char filterArr[] = new char[s.length()];
        for(int i=0, index=0; i < s.length(); i++){
            // start with ' ', just filter out
            if(s.charAt(i) == ' ' && flag == 0){
                continue;
            }
            // start with '-', flag = 1
            if(s.charAt(i) == '-' && flag == 0){
                flag = 1;
                continue;
            }
            // start with '+', flag = 2
            if(s.charAt(i) == '+' && flag == 0){
                flag = 2;
                continue;
            }
            // start with 0, flag = 3
            if(s.charAt(i) == '0' && flag == 0){
                flag = 3;
                continue;
            }
            // start with 1-9, flag = 4
            if(s.charAt(i) >= '1' && s.charAt(i) <= '9' && flag == 0){
                flag = 4;
                zeroFilterFlag = false;
                filterArr[index] = s.charAt(i);
                index++;
                continue;
            }

            if(s.charAt(i) == '0'){
                if(zeroFilterFlag){
                    continue;
                }
                filterArr[index] = s.charAt(i);
                index++;
                continue;
            }

            if(s.charAt(i) >= '1' && s.charAt(i) <= '9' && flag > 0){
                zeroFilterFlag = false;
                filterArr[index] = s.charAt(i);
                index++;
                continue;
            } else {
                break;
            }

        }
        String filterStr = new String(filterArr).trim();
        try {
            if(filterStr.length() > 10){
                if(flag == 1){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            } else {
                if(flag == 1){
                    Long rs = Long.parseLong("-"+filterStr);
                    if(rs < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                    return rs.intValue();
                }
                Long rs = Long.parseLong(filterStr);
                if(rs > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                return rs.intValue();
            }
        } catch (Exception e){
            return 0;
        }

    }

    private static int myAtoi(String s){
        // not start yet,  flag=0
        // skip ' '
        // started with '-' or '+', flag=1
        // start with '0', flag = 2
        // started with number, flag=3
        int flag = 0;
        char filterArray[] = new char[s.length()];
        for(int i=0, index=0; i < s.length(); i++){
            // start with ' '
            if( s.charAt(i) == ' ' && flag == 0){
                continue;
            }
            // start with valid numbers
            if( s.charAt(i) >= '1' && s.charAt(i) <= '9' && flag == 0 ){
                flag = 3;
                filterArray[i] = s.charAt(i);
            }
            // start with '-'
            if(s.charAt(i) == '-' && flag ==0){
                flag = 1;
                filterArray[index] = s.charAt(i);
                index++;
                continue;
            }
            // start with '+'
            if(s.charAt(i) == '+' && flag == 0){
                flag = 1;
                continue;
            }
            if(s.charAt(i) == '0'){
                if(flag == 0){
                    flag = 2;
                    continue;
                }
                if(flag > 2){
                    filterArray[index] = s.charAt(i);
                    index++;
                }
                continue;
            }
            // continue to add valid numbers
            if(s.charAt(i) >= '1' && s.charAt(i) <= '9' && flag > 0){
                flag = 3;
                filterArray[index] = s.charAt(i);
                index++;
                continue;
            } else {
                break;
            }
        }

        String filterStr = new String(filterArray).trim();
        try{
           Long filterRs = Long.parseLong(filterStr);
           if(filterRs < (long)Integer.MIN_VALUE){
               return Integer.MIN_VALUE;
           }
           if(filterRs > (long)Integer.MAX_VALUE){
               return Integer.MAX_VALUE;
           }

           return filterRs.intValue();
        } catch(Exception e){
           return 0;
        }
    }
}
