package practice;

public class T143_240824 {

    // 使用贪心 + 二分
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            if(n == 0){
                return 0;
            }
            int len = 1;
            int[] record = new int[n + 1];
            record[len] = nums[0];
            for(int i = 1; i < n; i ++){
                if(nums[i] > record[len]){
                    record[++len] = nums[i];
                }
                else {
                    int left = 1, right = len, index = 0;
                    while(left <= right){
                        int mid = left + (right - left) / 2;
                        if(record[mid] >= nums[i]) {
                            right = mid - 1;
                        }
                        else {
                            index = mid;
                            left = mid + 1;
                        }
                    }
                    record[index] = nums[i];
                }
            }
            return len;
        }
    }

}
