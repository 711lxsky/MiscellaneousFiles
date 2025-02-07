package DoubleWeekContest.Round137;

import java.util.*;

public class T1 {

    class Solution {
        public int[] resultsArray(int[] nums, int k) {
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int index = 0;
            List<Integer> record = new LinkedList<>();
            boolean flag = false, sameFlag = false;
            for(int i = 0; i < n; i ++){
                if(i >= k - 1){
                    if(i == k - 1){
                        flag = judge(record);
                    }
                    if(flag){
                        if(record.isEmpty() || record.get(record.size() - 1) + 1 == nums[i]){
                            res[index ++] = nums[i];
                        }
                        else {
                            flag = false;
                            res[index++] = -1;
                        }
                    }
                    else {
                        res[index++] = -1;
                        if(record.isEmpty() || record.get(record.size() - 1) + 1 == nums[i]){
                            sameFlag = true;
                        }
                        else {
                            sameFlag = false;
                        }
                    }
                    record.add(nums[i]);
                    record.remove(0);
                    if(sameFlag){
                        flag = judge(record);
                    }
                    if(record.size() == 1){
                        flag = true;
                    }
                }
                else {
                    record.add(nums[i]);
                }
            }
            return res;
        }

        public boolean judge(List<Integer> nums){
            for(int i = 1; i < nums.size(); i ++){
                if(nums.get(i) != nums.get(i-1) + 1){
                    return false;
                }
            }
            return true;
        }
    }



}
