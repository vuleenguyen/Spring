package com.lee;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';
        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'C';
        board[1][3] = 'S';
        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';
        System.out.println(board.length);
        System.out.println(board[0].length);
        System.out.println(isWordExist(board, "ABCCED"));
    }

    public static boolean isWordExist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int firstIndex = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if (findWordsMatch(board, i , j, word, firstIndex)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean findWordsMatch(char[][] board, int i, int j, String word, int k) {

        int m = board.length;
        int n = board[0].length;
        if(i<0 || j<0 || i>= m || j>= n){
            return false;
        }

        if(board[i][j] == word.charAt(k)){
            System.out.println(i + "and " + j);
            if (j == 3) {
                System.out.println("akjsdkjaskj");
            }
            char temp = board[i][j];
            board[i][j]='#';
            if(k == word.length()-1){
                return true;
            }else if(findWordsMatch(board, i-1, j,word, k+1)
                    ||findWordsMatch(board, i+1, j,word,  k+1)
                    ||findWordsMatch(board, i, j-1,word,  k+1)
                    ||findWordsMatch(board, i, j+1,word,  k+1)){
                return true;
            }
            board[i][j]=temp;
        }

        return false;
    }
}
