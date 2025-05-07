package practice;

public class T1312_250507 {

    class Solution {
        public int minInsertions(String s) {
            int n = s.length();
            String revS = new StringBuilder(s).reverse().toString();
            int[][] dp = new int[n+1][n+1];
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= n; j ++){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    if(s.charAt(i - 1) == revS.charAt(j - 1)){
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j-1]);
                    }
                }
            }
            return n * 2 - dp[n][n];
        }
    }

}
