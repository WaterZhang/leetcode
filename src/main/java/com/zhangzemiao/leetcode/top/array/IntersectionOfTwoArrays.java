package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;

public class IntersectionOfTwoArrays {

    /**
     *
     * @param nums1
     * @param nums2
     * @return result of intersection
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] small;
        int[] big;
        if(nums1.length > nums2.length){
            small = nums2;
            big = nums1;
        } else {
            small = nums1;
            big = nums2;
        }

        int count = 0;
        int[] result= new int[small.length];
        int[] hitPosition = new int[small.length];
        for(int i = 0; i < small.length; i++){
            for(int j = 0; j < big.length; j++){
                if(small[i] == big[j]){
                    boolean skip = false;
                    for(int z = 0; z < count; z++){
                        if(hitPosition[z] == j){
                            skip = true;
                        }
                    }
                    if(skip){
                        continue;
                    }
                    result[count] = small[i];
                    hitPosition[count] = j;
                    count++;
                    break;
                }
            }
        }
        int[] lastRs = new int[count];
        for(int i = 0; i < lastRs.length; i++){
            lastRs[i] = result[i];
        }
        return lastRs;
    }

}
