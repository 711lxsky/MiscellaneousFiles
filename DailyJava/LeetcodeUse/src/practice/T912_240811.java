package practice;

public class T912_240811 {

    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] nums, int start, int end){
            if(start < end){
                int partitionIndex = partition(nums, start, end);
                quickSort(nums, start, partitionIndex - 1);
                quickSort(nums, partitionIndex + 1, end);
            }
        }

        public int partition(int[] nums, int start, int end){
            int baseNum = nums[end];
            int left = start - 1;
            for(int right = start; right < end; right ++){
                if(nums[right] <= baseNum){
                    left ++;
                    swap(nums, left, right);
                }
            }
            swap(nums, left + 1, end);
            return left + 1;
        }

        public void swap(int[] nums, int index1, int index2){
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
//            nums[index1] = nums[index1] ^ nums[index2];
//            nums[index2] = nums[index1] ^ nums[index2];
//            nums[index1] = nums[index1] ^ nums[index2];
        }
    }

}
