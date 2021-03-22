package com.zhangzemiao.leetcode.top.sortingsearching;

/**
 * @Desc: first bad version
 * @author: wzhang
 * @date: 2021/3/22
 */
public class FirstBadVersion {

    public static void main(String[] args){
        int result = firstBadVersion(2126753390);
        System.out.println(result);
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end){
            int half = start+(end-start)/2;
            if(isBadVersion(half)){
                end = half;
            } else {
                start = half + 1;
            }
        }
        return start;
    }

    public static int firstBadVersionOne(int n){
        long start = 1;
        long end = n;
        do{
            long half =start + (end - start)/2;
            if(isBadVersion((int)half)){
                // [start,half]
                end = half;
            } else {
                // (half, end]
                start = half+1;
            }
        }while(end != start);
        return (int)start;
    }

    public static boolean isBadVersion(int n){
        if(n >= 1702766719){
            return true;
        }
        return false;
    }
}
