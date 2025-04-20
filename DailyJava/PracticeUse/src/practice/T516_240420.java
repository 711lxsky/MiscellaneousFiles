package practice;

public class T516_240420 {

    class Solution {
        public int longestPalindromeSubseq(String s) {
            // 当前左右位置指针对应的字符如果相等，那么可以从上一个状态直接 + 2
            int n = s.length();
            int[][] dp = new int[n][n];
            for(int i = n - 1; i >= 0; i --){
                dp[i][i] = 1;
                for(int j = i + 1; j < n; j ++){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + 2);
                    }else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[0][n-1];
        }
    }

}
