package LeetCode_Hot100;

import java.util.TreeMap;

public class P11_T239_231213 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            TreeMap<Integer, Integer> record = new TreeMap<>(
                    (a, b) -> b - a
            );
            int n = nums.length;
            int [] ans = new int[k];
            int left = 0 , right = 0 ;
            while(right < k){
                record.put(nums[right],record.getOrDefault(nums[right], 0) + 1);
                right ++;
            }
            while(right < n){
                ans[left] = record.firstKey();
                int time = record.get(nums[left]);
                if(time == 1){
                    record.remove(nums[left]);
                }
                else {
                    record.put(nums[left], time - 1);
                }
                record.put(nums[right],record.getOrDefault(nums[right], 0) + 1);
                left ++;
                right ++;
            }
            return ans;
        }
    }
}
