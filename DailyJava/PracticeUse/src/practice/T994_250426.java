package practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class T994_250426 {

    class Solution {

        public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dir = new int[][]{
                    {-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1}
            };
            Deque<int[]> myStack = new ArrayDeque<>();
            int res = 0, fresh = 0;
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(grid[i][j] == 2){
                        myStack.offer(new int[]{i, j});
                    }else if(grid[i][j] == 1){
                        fresh ++;
                    }
                }
            }
            while(fresh > 0 && ! myStack.isEmpty()){
                int curSize = myStack.size();
                for(int i = 0; i < curSize; i ++){
                    res ++;
                    int[] curOrange = myStack.poll();
                    for(int k = 0; k < 4; k ++){
                        int nextI = curOrange[0] + dir[k][0];
                        int nextJ = curOrange[1] + dir[k][1];
                        if(0 <= nextI && nextI < m && 0 <= nextJ && nextJ < n
                        && grid[nextI][nextJ] == 1){
                            fresh --;
                            grid[nextI][nextJ] = 2;
                            myStack.offer(new int[]{nextI, nextJ});
                        }
                    }
                }
            }
            if(fresh > 0){
                return -1;
            }
            return res;
        }
    }

}
