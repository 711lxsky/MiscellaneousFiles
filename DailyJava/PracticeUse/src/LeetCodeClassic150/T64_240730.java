package LeetCodeClassic150;

import java.util.Arrays;

public class T64_240730 {

    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(i == 0){
                        if(j == 0){
                            dp[i][j] = grid[i][j];
                        }
                        else {
                            dp[i][j] = dp[i][j-1] + grid[i][j];
                        }
                    }
                    else {
                        if(j == 0){
                            dp[i][j] = dp[i-1][j] + grid[i][j];
                        }
                        else {
                            // 左边 和 上面 选一个
                            dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                        }
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }

}
