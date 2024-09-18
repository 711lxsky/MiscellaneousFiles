package practice;

import java.util.Arrays;
import java.util.List;

public class T2915_240918 {

    class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int n = nums.size();
            // dp[i][j] 的定义是由前 i 个数组成 j 的最长序列
            int[][] dp = new int[n+1][target + 1];
            Arrays.fill(dp[0], Integer.MIN_VALUE);
            dp[0][0] = 0;
            for(int i = 0; i < n; i ++){
                int num = nums.get(i);
                for(int c = 0; c <= target; c ++){
                    if(c < num){
                        // 超出容量
                        dp[i + 1][c] = dp[i][c];
                    }
                    else {
                        dp[i + 1][c] = Math.max(dp[i][c], dp[i][c - num] + 1);
                    }
                }
            }
            return dp[n][target] <= 0 ? -1 : dp[n][target];
        }
    }

}
