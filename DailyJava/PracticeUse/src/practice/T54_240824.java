package practice;

import java.util.ArrayList;
import java.util.List;

public class T54_240824 {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int[][] dir = new int[][]{
                    {0, 1}, {1, 0}, {0, -1}, {-1, 0}
            };
            int m = matrix.length, n = matrix[0].length;
            boolean[][] visited = new boolean[m][n];
            int sum = m * n, curRowIndex = 0, curLineIndex = 0, dirIndex = 0;
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < sum; i ++){
                res.add(matrix[curRowIndex][curLineIndex]);
                visited[curRowIndex][curLineIndex] = true;
                int nexRow = curRowIndex + dir[dirIndex][0], nextLine = curLineIndex + dir[dirIndex][1];
                if(nexRow < 0 || nexRow >= m || nextLine < 0 || nextLine >= n || visited[nexRow][nextLine]){
                    dirIndex = (dirIndex + 1) % 4;
                }
                curRowIndex += dir[dirIndex][0];
                curLineIndex += dir[dirIndex][1];
            }
            return res;
        }
    }

}
