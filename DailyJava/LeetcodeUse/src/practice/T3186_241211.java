package practice;

import java.util.*;
import java.util.stream.Collectors;

public class T3186_241211 {

    class Solution {
        public long maximumTotalDamage(int[] power) {
            // 因为数据量的规模较大，所以首先必须啊排除桶方法
            Map<Integer, Integer> record = new HashMap<>();
            for(int p : power){
                record.merge(p, 1, Integer::sum);
            }
            // 将存在的整数全部拿出
            Integer[] nums = record.keySet().toArray(new Integer[0]);
            Arrays.sort(nums);
            int n = nums.length;
            long[] dp = new long[n + 1];
            int j = 0;
            for(int i = 0; i < n; i ++){
                int cur = nums[i];
                while(nums[j] < cur - 2){
                    j ++;
                }
                dp[i + 1] = Math.max(dp[i], dp[j] + (long) cur * record.get(cur));
            }
            return dp[n];
        }
    }

}
