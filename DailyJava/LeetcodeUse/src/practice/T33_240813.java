package practice;

public class T33_240813 {

    /**
     * 不论怎么看，将数组平分，都有一半是有序的
     */
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            for(int left = 0, right = n - 1; left <= right; ){
                int mid = left + (right - left) / 2;
                if(nums[mid] == target){
                    return mid;
                }
                // 左侧有序
                if(nums[left] <= nums[mid]){
                    if(nums[left] <= target && nums[mid] > target){
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                // 反之，右侧有序
                else {
                    if(nums[mid] < target && nums[right] >= target){
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

}
