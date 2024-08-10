package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yuyang
 * @Date 2024/8/9
 * @Description
 */
public class T15_240809 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for(int first = 0; first < n; first ++){
                if(first > 0 && nums[first] == nums[first - 1]){
                    continue;
                }
                int target = -nums[first];
                for(int second = first + 1, third = n - 1 ; second < n && second < third;){
                    if(second > first + 1 && nums[second] == nums[second - 1]){
                        second ++;
                        continue;
                    }
                    if(nums[second] + nums[third] == target){
                        res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                        second ++;
                        third --;
                    }
                    else if(nums[second] + nums[third] < target){
                        second ++;
                    }
                    else {
                        third --;
                    }
                }
            }
            return res;
        }
    }

}
