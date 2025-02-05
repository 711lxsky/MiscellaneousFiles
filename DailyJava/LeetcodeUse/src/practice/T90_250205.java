package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90_250205 {

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // 先将数组排序
            Arrays.sort(nums);
            int n = nums.length;
            for(int mask = 0; mask < (1 << n); mask ++){
                List<Integer> cur = new ArrayList<>();
                boolean dif = true;
                for(int i = 0; i < n; i ++){
                    if( (mask & (1 << i)) != 0){
                        if(i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i-1]){
                            dif = false;
                            break;
                        }
                        cur.add(nums[i]);
                    }
                }
                if(dif){
                    res.add(new ArrayList<>(cur));
                }
            }
            return res;
        }
    }

}
