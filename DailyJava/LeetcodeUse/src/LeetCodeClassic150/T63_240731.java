package LeetCodeClassic150;

import java.util.Arrays;

public class T63_240731 {

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[] dp = new int[n];
            dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(1 == obstacleGrid[i][j]){
                        dp[j] = 0;
                        continue;
                    }
                    if(j >= 1 && obstacleGrid[i][j-1] == 0){
                        dp[j] += dp[j-1];
                    }
                }
            }
            return dp[n-1];
        }
    }

}
