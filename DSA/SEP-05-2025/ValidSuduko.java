// https://leetcode.com/problems/valid-sudoku/

import java.util.*;


class Solution {

    public boolean isValidSubGrid(char[][] board, int sr, int er, int sc, int ec) {
        Set<Character> st = new HashSet<>();
        for(int i = sr; i<=er; i++) {
            for(int j = sc; j<=ec; j++) {
                if(board[i][j] == '.') continue;
                if(st.contains(board[i][j])) return false;
                else st.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i<9; i++) {
            Set<Character> st = new HashSet<>();
            for(int j = 0; j<9; j++) {
                if(board[i][j] == '.') continue;
                if(st.contains(board[i][j])) return false;
                else st.add(board[i][j]);
            }
        }


        for(int i = 0; i<9; i++) {
            Set<Character> st = new HashSet<>();
            for(int j = 0; j<9; j++) {
                if(board[j][i] == '.') continue;
                if(st.contains(board[j][i])) return false;
                else st.add(board[j][i]);
            }
        }

        System.out.print("reaching here");

        for(int i = 0; i<9; i+=3) {
            for(int j = 0; j<9; j+=3) {
                if(!isValidSubGrid(board, i, i+2, j, j+2)) return false;
            }
        }

        return true;

    }
}
