package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class T347_240613 {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // 利用堆来做
            Map<Integer, Integer> record = new HashMap<>();
            for(int num : nums){
                record.put(num, record.getOrDefault(num, 0)+1);
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>(
                    (a, b) -> b[1] - a[1]
            );
            for(Map.Entry<Integer, Integer> entry : record.entrySet()){
                int num = entry.getKey();
                int time = entry.getValue();
                if(queue.size() == k){
                    int[] peek = queue.peek();
                    if(peek[1] < time){
                        queue.poll();
                        queue.offer(new int[]{num, time});
                    }
                }else {
                    queue.offer(new int[]{num, time});
                }
            }
            int [] ans = new int[k];
            for(int i = 0; i < k; i ++){
                ans[i] = queue.poll()[0];
            }
            return ans;
        }
    }

}
