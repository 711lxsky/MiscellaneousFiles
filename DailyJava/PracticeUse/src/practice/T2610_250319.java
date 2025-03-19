package practice;

import java.util.*;

public class T2610_250319 {

    class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            Map<Integer, Integer> record = new HashMap<>();
            List<Set<Integer>> res = new ArrayList<>();
            int n = nums.length;
            res.add(new HashSet<>());
            for(int num : nums){
                int size = res.size();
                for(int i = 0; i < size; i ++){
                    if(!res.get(i).contains(num)){
                        res.get(i).add(num);
                        break;
                    }
                    if(i == size - 1){
                        res.add(new HashSet<>());
                        res.get(size).add(num);
                    }
                }
            }
            List<List<Integer>> ans = new ArrayList<>();
            for(Set<Integer> set : res){
                List<Integer> list = new ArrayList<>();
                for(int num : set){
                    list.add(num);
                }
                ans.add(list);
            }
            return ans;
        }
    }

}
