package practice;

public class T59_250207 {

    class Solution {

        public int[][] generateMatrix(int n) {
            int[][] dir = new int[][]{
                    {0, 1}, {1, 0}, {0, -1}, {-1, 0}
            };
            boolean[][] vis = new boolean[n][n];
            int[][] res = new int[n][n];
            int time = n * n, num = 1;
            for(int t = 0, i = 0, j = 0, dirIndex = 0; t < time; t++){
                res[i][j] = num;
                vis[i][j] = true;
                num ++;
                int nextRow = i + dir[dirIndex][0], nextCol = j + dir[dirIndex][1];
                if(nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == n || vis[nextRow][nextCol]){
                    dirIndex = (dirIndex + 1) % 4;
                }
                i += dir[dirIndex][0];
                j += dir[dirIndex][1];
            }
            return res;
        }
    }

}
