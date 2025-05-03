package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1027_250503 {

    class Solution {
        public int longestArithSeqLength(int[] nums) {
             int n = nums.length;
            Map<Integer, Integer>[] dp = new HashMap[n];
            Arrays.setAll(dp, e -> new HashMap<>());
            int res = 1;
            for(int i = 0; i < n; i ++){
                for(int j = i - 1; j >= 0; j --){
                    int d = nums[i] - nums[j];
                    if(! dp[i].containsKey(d)){
                        dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);
                        res = Math.max(res, dp[i].get(d));
                    }
                }
            }
            return res;
        }
    }

}
