package LeetCodeClassic150;

import java.util.Arrays;

public class T62_240731 {

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[2][n];
            Arrays.fill(dp[0], 1);
            Arrays.fill(dp[1], 1);
            for(int i = 1; i < m; i ++){
                for(int j = 1; j < n; j ++){
                    dp[1][j] = dp[1][j-1] + dp[0][j];
                }
                dp[0] = dp[1].clone();
            }
            return dp[1][n-1];
        }
    }

}
