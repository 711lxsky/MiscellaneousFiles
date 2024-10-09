package practice;

public class T41_241009 {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 将某个正数数放到其应该放置的位置即可
            int n = nums.length;
            for(int i = 0; i < n; i ++){
                // 当前位置的数属于正常正数、 且没有放在正确位置
                while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                    // 进行位置的交换
                    swap(nums, i, nums[i] - 1);
                }
            }
            // 遍历检查缺失的正数
            for(int i = 0; i < n; i ++){
                if(nums[i] != i + 1){
                    return i + 1;
                }
            }
            return n;
        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
