package LeetCodeClassic150;

import java.util.Arrays;

public class T322_240728 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = Integer.MAX_VALUE / 2, n = coins.length;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for(int i = 1; i <= amount; i ++){
                for(int j = 0; j < n && coins[j] <= i; j ++){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]) + 1;
                }
            }
            return dp[amount] > max ? -1 : dp[amount];
        }
    }

}
