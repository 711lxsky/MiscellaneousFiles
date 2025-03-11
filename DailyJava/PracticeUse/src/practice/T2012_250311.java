package practice;

public class T2012_250311 {

    static class Solution {
        public int sumOfBeauties(int[] nums) {
            // 记录左侧最大值和右侧最小值
            int n = nums.length;
            int[] left = new int[n];
            left[0] = Integer.MAX_VALUE;
            int max = nums[0];
            int[] right = new int[n];
            right[n-1] = Integer.MIN_VALUE;
            int min = nums[n-1];
            for(int i = 1; i < n; i ++){
                int j = n - i - 1;
                left[i] = max;
                max = Math.max(max, nums[i]);
                right[j] = min;
                min = Math.min(min, nums[j]);
            }
            int res = 0;
            for(int i = 1; i < n - 1; i ++){
                if(left[i] < nums[i] && nums[i] < right[i]){
                    res += 2;
                }else if(nums[i-1] < nums[i] && nums[i] < nums[i+1]){
                    res += 1;
                }else {
                    res += 0;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,7,8,9,10};
        Solution solution = new Solution();
        System.out.println(solution.sumOfBeauties(nums));
    }

}
