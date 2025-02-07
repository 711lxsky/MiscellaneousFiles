package LeetCode_Hot100;

/**
 * @Author: 711lxsky
 * @Date: 2023-12-30
 */

public class P16_T238_231230 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 计算每个数的左右累计乘积即可
            int n = nums.length;
            int temp = 1;
            int [] ans = new int[n];
            // 累乘左边
            for(int i = 0; i < n; i ++){
                ans[i] = temp;
                temp *= nums[i];
            }
            // 累乘右边
            temp = 1;
            for(int i =  n - 1; i >= 0; i --){
                ans[i] *= temp;
                temp *= nums[i];
            }
            return ans;
        }
    }
}
