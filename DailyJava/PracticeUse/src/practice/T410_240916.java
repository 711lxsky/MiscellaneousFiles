package practice;

public class T410_240916 {

    class Solution {
        public int splitArray(int[] nums, int k) {
            int n = nums.length;
            int maxNum = 0, sum = 0;
            for(int num : nums){
                maxNum = Math.max(num, maxNum);
                sum += num;
            }
            int left = maxNum, right = sum;
            while(left < right){
                // 找到一个合适的数字能够使得分割得恰好
                int mid = left + (right - left) / 2;
                int splitNum = split(nums, mid);
                if(splitNum > k){
                    // 划分的上界过小
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            return left;
        }

        public int split(int[] nums, int boundNum){
            int splitNum = 1;
            int curSum = 0;
            for(int num : nums){
                if(curSum + num > boundNum){
                    curSum = 0;
                    splitNum ++;
                }
                curSum += num;
            }
            return splitNum;
        }


    }

}
