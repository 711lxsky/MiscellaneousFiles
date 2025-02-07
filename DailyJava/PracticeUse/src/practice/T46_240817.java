package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T46_240817 {

    class Solution {

        List<List<Integer>> res;

        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            backTrace(nums, 0);
            return res;
        }

        public void backTrace(int[] nums, int index){
            int n = nums.length;
            if(index == n){
                List<Integer> curRes = Arrays.stream(nums).boxed().collect(Collectors.toList());
                res.add(curRes);
                return;
            }
            for(int i = index; i < n; i ++){
                swap(nums, i, index);
                backTrace(nums, index + 1);
                swap(nums, i, index);
            }
        }

        public void swap(int[] nums, int index1, int index2){
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

}
