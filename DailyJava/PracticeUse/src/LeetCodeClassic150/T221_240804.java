package LeetCodeClassic150;

public class T221_240804 {

    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return 0;
            }
            int m = matrix.length, n = matrix[0].length;
            int maxLen = 0;
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(matrix[i][j] == '1'){
                        if(i == 0 || j == 0){
                            dp[i][j] = 1;
                        }else {
                            dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                        }
                        maxLen = Math.max(maxLen, dp[i][j]);
                    }
                }
            }
            return maxLen * maxLen;
        }
    }

}
