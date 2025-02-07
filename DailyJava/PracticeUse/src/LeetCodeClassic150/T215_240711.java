package LeetCodeClassic150;

public class T215_240711 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            buildHeap(nums, heapSize);
            int n = heapSize;
            for(int i = n - 1; i >= n - k + 1; i --){
                swap(nums, 0, i);
                heapSize --;
                heapify(nums, 0, heapSize);
            }
            return nums[0];
        }

        public void buildHeap(int[] nums, int heapSize){
            for(int i = heapSize/2; i >= 0; i --){
                heapify(nums, i, heapSize);
            }
        }

        public void heapify(int[] nums, int index, int heapSize){
            int largest = index, left = index * 2 + 1, right = index * 2 + 2;
            if(left < heapSize && nums[left] > nums[largest]){
                largest = left;
            }
            if(right < heapSize && nums[right] > nums[largest]){
                largest = right;
            }
            if(largest !=index){
                swap(nums, largest, index);
                heapify(nums, largest, heapSize);
            }
        }

        public void swap(int[] nums, int index1, int index2){
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

}
