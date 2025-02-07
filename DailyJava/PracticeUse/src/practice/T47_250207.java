package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47_250207 {

    class Solution {

        List<List<Integer>> res;
        boolean[] vis;

        public List<List<Integer>> permuteUnique(int[] nums) {
            res = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            vis = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums, 0, cur);
            return res;
        }

        public void backtrack(int[] nums, int index, List<Integer> cur){
            if(index == nums.length){
                res.add(new ArrayList<>(cur));
                return;
            }
            for(int i = 0; i < nums.length; i ++){
                if(vis[i] || (i > 0 && nums[i] == nums[i-1] && ! vis[i-1])){
                    continue;
                }
                cur.add(nums[i]);
                vis[i] = true;
                backtrack(nums, index + 1, cur);
                vis[i] = false;
                // 注意这里
                cur.remove(index);
            }
        }
    }

}
