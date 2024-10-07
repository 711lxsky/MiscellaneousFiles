package practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class T239_241005 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 使用双端队列
            Deque<Integer> record = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n - k + 1];
            for(int i = 0; i < n; i ++){
                // 将队列中所有小于当前元素的值移除
                while(! record.isEmpty() && nums[record.peekLast()] < nums[i]){
                    record.pollLast();
                }
                // 将当前元素放入
                record.offerLast(i);
                // 检查是否需要将队头移出
                if(record.peekFirst() <= i - k){
                    record.pollFirst();
                }
                // 检查是否需要加入结果
                if(i >= k - 1){
                    res[i - k + 1] = nums[record.peekFirst()];
                }
            }
            return res;
        }
    }

}
