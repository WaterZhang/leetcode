package com.zhangzemiao.leetcode.top.array;

import java.util.Arrays;

/**
 * @Desc: Rotate image
 * @author: wzhang
 * @date: 2021/1/11
 */
public class RotateImage {

    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate(int[][] matrix){
        for(int i=0; i< matrix.length / 2; i++){

            int offset = matrix.length-i*2-1;
            //four corner exchange
            //matrix[i][i], matrix[i][i+offset], matrix[i+offset][i+offset], matrix[i+offset][i]

            //top
            int current =  matrix[i][i];
            int excharge = matrix[i][i+offset];
            matrix[i][i+offset] = current;

            //right
            current = excharge;
            excharge = matrix[i+offset][i+offset];
            matrix[i+offset][i+offset] = current;

            //bottom
            current = excharge;
            excharge = matrix[i+offset][i];
            matrix[i+offset][i] = current;

            //left
            current = excharge;
            matrix[i][i] = current;

            // top -> right -> bottom -> left
            // matrix[i][i], matrix[i][i+offset], matrix[i+offset][i+offset], matrix[i+offset][i]
            for(int m=1; m < offset; m++){
                current = matrix[i][i+m];
                excharge = matrix[i+m][i+offset];
                matrix[i+m][i+offset] = current;

                current = excharge;
                excharge = matrix[i+offset][i+offset-m];
                matrix[i+offset][i+offset-m] = current;

                current = excharge;
                excharge = matrix[i+offset-m][i];
                matrix[i+offset-m][i] = current;

                current = excharge;
                matrix[i][i+m] = current;
            }

        }
    }
}
