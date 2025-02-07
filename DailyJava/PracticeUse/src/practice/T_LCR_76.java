package practice;

import java.util.PriorityQueue;

public class T_LCR_76 {

    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            // 直接使用堆
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (a, b) -> b - a
            );
            for(int num : nums){
                pq.offer(num);
            }
            for(int i = 1; i < k; i ++){
                pq.poll();
            }
            return pq.poll();
        }
    }

    class Solution2 {

        public int findKthLargest(int[] nums, int k) {
            // 使用快速选择算法
            int n = nums.length;
            return quickSelect(nums, 0, n - 1, n - k);
        }

        public int quickSelect(int[] nums, int l, int r, int k){
            if(l == r){
                return nums[k];
            }
            int baseNum = nums[l];
            int i = l - 1, j = r + 1;
            while(i < j){
                do i ++; while(nums[i] < baseNum);
                do j --; while(nums[j] > baseNum);
                if(i < j) swap(nums, i, j);
            }
            if(k <= j){
                return quickSelect(nums, l, j, k);
            }
            return  quickSelect(nums, j + 1, r, k);

        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            buildHeap(nums, heapSize);
            for(int i = 0; i < k - 1; i ++){
                swap(nums, 0, heapSize - 1);
                heapSize --;
                heapify(nums, 0, heapSize);
            }
            return nums[0];
        }

        public void buildHeap(int[] nums, int heapSize){
            for(int i = heapSize / 2; i >= 0; i --){
                heapify(nums, i, heapSize);
            }
        }

        public void heapify(int[] nums, int index, int heapSize){
            int largestIndex = index, left = index * 2 + 1, right = index * 2 + 2;
            if(left < heapSize && nums[left] > nums[largestIndex]) largestIndex = left;
            if(right < heapSize && nums[right] > nums[largestIndex]) largestIndex = right;
            if(largestIndex != index) {
                swap(nums, index, largestIndex);
                heapify(nums, largestIndex, heapSize);
            }
        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }

}
