package LeetCodeClassic150;

public class T79_240621 {

    class Solution {

        public int [][] dirs = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        public char[][] board;
        public boolean[][] visit;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.visit = new boolean[board.length][board[0].length];
            for(int i = 0; i < board.length; i ++){
                for(int j = 0; j < board[0].length; j ++){
                    if(backtrace(word, i, j, 0)){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean backtrace(String word, int rowIndex, int colIndex, int curLen){
            if(curLen == word.length()){
                return true;
            }
            if(rowIndex < 0 || rowIndex >= board.length
                || colIndex < 0 || colIndex >= board[0].length
                || visit[rowIndex][colIndex]){
                return false;
            }
            if( board[rowIndex][colIndex] == word.charAt(curLen)){
                visit[rowIndex][colIndex] = true;
                for(int[] dir : dirs){
                    int nextRow = rowIndex + dir[0], nextCol = colIndex +dir[1];
                    if(backtrace(word, nextRow, nextCol, curLen + 1)){
                        return true;
                    }
                }
                visit[rowIndex][colIndex] = false;
            }
            return false;
        }
    }

}
