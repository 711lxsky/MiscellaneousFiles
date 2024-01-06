package DoubleWeekContest.Round121;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: 711lxsky
 * @Date: 2024-01-06
 */

public class Problem1 {

    static class Solution {
        public int missingInteger(int[] nums) {
            // 先哈希表存一下
            Set<Integer> records = new HashSet<>();
            for(int num : nums){
                records.add(num);
            }
            int n = nums.length;
            int pre = 0, sum = 0, maxSum = 0, len = 0, maxLen = 0;
            for(int i = 0; i < n; i ++ ){
                if(i == 0 || nums[i] == nums[i-1] + 1){
                    sum += nums[i];
                    len ++;
                }
                else {
                    sum = nums[i];
                    len = 1;
                }
                if(len > maxLen){
                    maxLen = len;
                    maxSum = sum;
                }
//                maxSum = Math.max(sum, maxSum);
            }
//            maxSum = Math.max(sum, maxSum);
            for(int i = maxSum; ;i ++){
                if(!records.contains(i)){
                    return i;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().missingInteger(new int[]{14,9,6,9,7,9,10,4,9,9,4,4});

    }

}
