package practice;

import java.util.ArrayList;
import java.util.List;

public class T78_1018 {

    class Solution {

        List<List<Integer>> res;
        public List<List<Integer>> subsets(int[] nums) {
            res = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(0, nums.length, cur, nums);
            return res;
        }

        public void dfs(int index, int n, List<Integer> cur, int[] nums){
            if(index == n){
                res.add(new ArrayList<>(cur));
                return;
            }
            cur.add(nums[index]);
            dfs(index + 1, n, cur, nums);
            cur.remove(cur.size() - 1);
            dfs(index + 1, n, cur, nums);
        }
    }

}
