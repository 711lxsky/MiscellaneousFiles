package LeetCodeClassic150;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class T373_240715 {

    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            PriorityQueue<int[]> myQueue = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
            List<List<Integer>> ans = new ArrayList<>();
            int bound = Math.min(m, k);
            for(int i = 0; i < bound; i ++){
                myQueue.offer(new int[]{i, 0});
            }
            while(k -- > 0 && ! myQueue.isEmpty()) {
                int [] cur = myQueue.poll();
                List<Integer> curList = new ArrayList<>();
                curList.add(nums1[cur[0]]);
                curList.add(nums2[cur[1]]);
                ans.add(curList);
                if(cur[1] + 1 < n){
                    myQueue.offer(new int[]{cur[0], cur[1] + 1});
                }
            }
            return ans;
        }
    }

}
