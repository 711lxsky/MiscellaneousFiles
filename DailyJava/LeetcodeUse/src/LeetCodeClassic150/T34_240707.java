package LeetCodeClassic150;

public class T34_240707 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int leftIndex = search(nums, target, true);
            int rightIndex = search(nums, target, false) - 1;
            if(leftIndex > rightIndex || leftIndex < 0 || rightIndex >= nums.length){
                return new int[]{-1, -1};
            }
            return new int[]{leftIndex, rightIndex};
        }


        public int search(int[] nums, int target, boolean lower){
            int left = 0, right = nums.length - 1, res = nums.length;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] > target || (lower && nums[mid] >= target)){
                    right = mid - 1;
                    res = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            return res;
        }

    }

}
