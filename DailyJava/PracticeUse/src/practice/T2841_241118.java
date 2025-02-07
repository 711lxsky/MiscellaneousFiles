package practice;

import java.util.*;

public class T2841_241118 {

    class Solution {
        public long maxSum(List<Integer> nums, int m, int k) {
            // 滑动窗口 + 哈希表
            int n = nums.size();
            long res = 0, sum = 0;
            Map<Integer, Integer> record = new HashMap<>();
            for(int i = 0; i < n; i ++ ){
                record.put(nums.get(i), record.getOrDefault(nums.get(i), 0) + 1);
                sum += nums.get(i);
                if(i - k + 1 < 0){
                    continue;
                }
                if(record.size() >= m){
                    res = Math.max(res, sum);
                }
                int time = record.get(nums.get(i - k + 1));
                if(time == 1){
                    record.remove(nums.get(i - k + 1));
                }
                else {
                    record.put(nums.get(i - k + 1), time - 1);
                }
                sum -= nums.get(i - k + 1);
            }
            return res;
        }
    }

}
