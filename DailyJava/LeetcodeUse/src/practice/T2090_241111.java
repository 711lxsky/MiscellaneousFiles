package practice;

/**
 * @Author yuyang
 * @Date 2024/11/11
 * @Description
 */
public class T2090_241111 {

    class Solution {
        public int[] getAverages(int[] nums, int k) {
            // 直接走就好了
            int n = nums.length, i = 0, sum = 0;
            int[] res = new int[n];
            while(i < k - 1){
                res[i] = -1;
                sum += nums[i] + nums[i + k];
                i ++;
            }
            while(i < n - k + 1){
                sum += nums[i + k];
                res[i] = sum / (2 * k + 1);
                sum -= nums[i - k];
                i ++;
            }
            while(i < n){
                res[i] = -1;
                i++;
            }
            return res;
        }
    }

}
