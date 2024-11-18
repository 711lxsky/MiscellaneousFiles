package practice;

import java.util.HashMap;
import java.util.Map;

public class T2461_241118 {

    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            // 滑动窗口 + 哈西表
            int n = nums.length;
            long res = 0, sum = 0;
            Map<Integer, Integer> record = new HashMap<>();
            for(int i = 0; i < n; i ++){
                record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
                sum += nums[i];
                if(i - k + 1 < 0){
                    continue;
                }
                if(k == record.size()){
                    res = Math.max(res, sum);
                }
                int time = record.get(nums[i - k + 1]);
                if(time == 1){
                    record.remove(nums[i - k + 1]);
                }
                else {
                    record.put(nums[i - k + 1], time - 1);
                }
                sum -= nums[i - k + 1];
            }
            return res;
        }
    }

}
