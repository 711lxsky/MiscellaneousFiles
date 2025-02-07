package LeetCodeClassic150;

public class T162_240705 {

    class Solution1 {
        public int findPeakElement(int[] nums) {
            int max = Integer.MIN_VALUE, maxIndex = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] > max) {
                    maxIndex = i;
                    max = nums[i];
                }
            }
            return maxIndex;
        }
    }

    class Solution {
        public int findPeakElement(int[] nums){
            int left = 0, right = nums.length - 1;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(nums[mid] > nums[mid + 1]){
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
