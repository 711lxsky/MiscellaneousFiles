package LeetCodeClassic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T46_240616 {

    class Solution {

        List<List<Integer>> res;

        public List<List<Integer>> permute(int[] nums) {
            this.res = new ArrayList<>();
           backtrack(nums, 0);
           return res;
        }

        public void backtrack(int[] nums, int index){
            int n = nums.length;
            if(index == n){
                List<Integer> curRes = new ArrayList<>();
                for(int num : nums){
                    curRes.add(num);
                }
                res.add(curRes);
            }
            for(int i = index; i < n; i ++){
                swap(nums, i, index);
                backtrack(nums, index + 1);
                swap(nums, i, index);
            }
        }

        public void swap(int [] arr, int index1, int index2){
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }

}
