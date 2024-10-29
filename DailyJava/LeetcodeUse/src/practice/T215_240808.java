package practice;

public class T215_240808 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int size = nums.length;
            buildHeap(nums, size);
            for(int i = 0; i < k - 1; i ++){
                swap(nums, 0, size - 1);
                size --;
                heapify(nums, 0, size);
            }
            return nums[0];
        }

        public void buildHeap(int[] nums, int heapSize){
            for(int i = heapSize / 2; i >= 0; i --){
                heapify(nums, i, heapSize);
            }
        }

        public void heapify(int[] nums, int index, int heapSize){
            int leftSonIndex = index * 2 + 1, rightSonIndex = index * 2 + 2;
            int largestIndex = index;
            if(leftSonIndex < heapSize && nums[leftSonIndex] > nums[largestIndex]){
                largestIndex = leftSonIndex;
            }
            if(rightSonIndex < heapSize && nums[rightSonIndex] > nums[largestIndex]){
                largestIndex = rightSonIndex;
            }
            if(largestIndex != index){
                swap(nums, largestIndex, index);
                heapify(nums, largestIndex, heapSize);
            }
        }

        public void swap(int[] nums, int index1, int index2){
            nums[index1] = nums[index1] ^ nums[index2];
            nums[index2] = nums[index1] ^ nums[index2];
            nums[index1] = nums[index1] ^ nums[index2];
        }
    }

}
