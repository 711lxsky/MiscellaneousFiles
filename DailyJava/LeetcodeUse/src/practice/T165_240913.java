package practice;

public class T165_240913 {

    class Solution {
        public int crackNumber(int ciphertext) {
            String num = String.valueOf(ciphertext);
            int n = num.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i ++){
                int cur = (num.charAt(i - 2) - '0') * 10 + (num.charAt(i-1) - '0');
                if(num.charAt(i - 2) != '0' && cur >= 0 && cur <= 25){
                    dp[i] = dp[i-1] + dp[i-2];
                }
                else {
                    dp[i] = dp[i-1];
                }
            }
            return dp[n];
        }
    }

}
