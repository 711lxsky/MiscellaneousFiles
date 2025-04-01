package practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class T239_250401 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> record = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n - k + 1];
            for(int i = 0; i < n; i ++){
                int num = nums[i];
                // 将小值移除
                while(! record.isEmpty() && nums[record.peekLast()] <= num){
                    record.pollLast();
                }
                // 放入当前值
                record.offerLast(i);
                if(record.peekFirst() <= i - k){
                    record.pollFirst();
                }
                if(i >= k - 1){
                    res[i - k + 1] = nums[record.peekFirst()];
                }
            }
            return res;
        }
    }

}
