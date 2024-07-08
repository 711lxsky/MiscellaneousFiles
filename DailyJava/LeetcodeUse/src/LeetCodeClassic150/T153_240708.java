package LeetCodeClassic150;

public class T153_240708 {

    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            int minNum = Integer.MAX_VALUE;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[left] <= nums[mid]){
                    // 左侧有序
                    minNum = Math.min(minNum, nums[left]);
                    left = mid + 1;
                }
                else {
                    // 反之右侧有序
                    minNum = Math.min(minNum, nums[mid]);
                    right = mid - 1;
                }
            }
            return minNum;
        }
    }

}
