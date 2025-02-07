package practice;

public class T300_240622 {

    class Solution {
        // 一维动态规划
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int [] dp = new int[n];
            for(int i = 0; i < n; i ++){
                dp[i] = 1;
                for(int j = 0; j < i; j ++){
                    if(nums[j] < nums[i]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int maxLen = 0;
            for(int len : dp){
                maxLen = Math.max(maxLen, len);
            }
            return maxLen;
        }
    }

}
