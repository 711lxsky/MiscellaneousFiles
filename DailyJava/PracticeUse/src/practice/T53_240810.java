package practice;

public class T53_240810 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE, n = nums.length;
            for(int sum = 0, i = 0; i < n; i ++){
                if(sum <= 0){
                    sum = nums[i];
                }
                else {
                    sum += nums[i];
                }
                maxSum = Math.max(maxSum, sum);
            }
            return maxSum;
        }
    }

}
