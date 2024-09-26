package practice;

public class T416_240926 {

    class Solution {
        public boolean canPartition(int[] nums) {
            // 等和一定需要能够均匀两半，nums和为偶
            int sum = 0;
            for(int num : nums){
                sum += num;
            }
            if(sum % 2 != 0){
                return false;
            }
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
            return dp[target];
        }
    }

}
