package LeetCodeClassic150;

public class T33_240706 {

    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(target == nums[mid]){
                    return mid;
                }
                if(nums[left] <= nums[mid]){
                    // 左侧有序
                    if(nums[left] <= target && nums[mid] > target){
                        // target在此区间中
                        right = mid - 1;
                    }
                    else {
                        // 在另外一边
                        left = mid + 1;
                    }
                }
                else {
                    // 右侧有序
                    // 后续逻辑同理
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
