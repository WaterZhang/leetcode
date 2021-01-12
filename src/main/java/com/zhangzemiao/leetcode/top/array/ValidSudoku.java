package com.zhangzemiao.leetcode.top.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc: Valid Sudoku
 * @author: wzhang
 * @date: 2021/1/11
 */
public class ValidSudoku {

    public static void main(String[] args){
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board){
        //check row
        Set<Character> characters = new HashSet<>();
        for(int i=0; i< board.length; i++){
            //check row
            characters.clear();
            for(int k=0; k < board.length; k++){
                if(board[i][k] != '.'){
                    if(characters.contains(board[i][k])){
                        return false;
                    } else {
                        characters.add(board[i][k]);
                    }
                }
            }
        }

        //check column
        characters.clear();
        for(int i=0; i< board.length; i++){
            //check row
            characters.clear();
            for(int k=0; k < board.length; k++){
                if(board[k][i] != '.'){
                    if(characters.contains(board[k][i])){
                        return false;
                    } else {
                        characters.add(board[k][i]);
                    }
                }
            }
        }

        //check every 3X3 box
        for(int i=0; i < board.length; i+=3){
            for(int j=0; j < board.length; j+=3){
                characters.clear();
                for(int m=i; m <= i+2; m++){
                    for(int n=j; n <= j+2; n++){
                        if(board[m][n] != '.'){
                            if(characters.contains(board[m][n])){
                                return false;
                            } else {
                                characters.add(board[m][n]);
                            }
                        }
                    }
                }

            }
        }

        return true;
    }

}
