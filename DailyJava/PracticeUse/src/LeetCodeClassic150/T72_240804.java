package LeetCodeClassic150;

public class T72_240804 {

    /**
     * 动规做法
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            // dp[i][j] 表示的是 A的前 i 个字母和 B的前 j 个字母之间的转换距离
            int m = word1.length(), n = word2.length();
            if(m * n == 0){
                return m + n;
            }
            int[][] dp = new int[m+1][n+1];
            for(int i = 0; i <= m; i ++){
                dp[i][0] = i;
            }
            for(int j = 0; j <= n; j ++){
                dp[0][j] = j;
            }
            for(int i = 1; i <= m; i ++){
                for(int j = 1; j <= n; j ++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1] - 1));
                    }
                    else {
                        dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    }
                }
            }
            return dp[m][n];
        }
    }

}
