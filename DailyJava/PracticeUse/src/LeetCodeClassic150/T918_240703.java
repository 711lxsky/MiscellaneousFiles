package LeetCodeClassic150;

public class T918_240703 {

    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int maxS = Integer.MIN_VALUE;
            int minS = 0;
            int maxF = 0, minF = 0, sum = 0;
            for(int num : nums){
                maxF = Math.max(maxF, 0) + num;
                maxS = Math.max(maxS, maxF);
                minF = Math.min(minF, 0) + num;
                minS = Math.min(minS, minF);
                sum += num;
            }
            return sum == minS ? maxS : Math.max(maxS, sum - minS);
        }
    }

}
