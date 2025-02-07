package LeetCodeClassic150;

import java.util.ArrayList;
import java.util.List;

public class T77_240615 {

    static class Solution {

        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(n, 1, k);
            return res;
        }

        public void dfs(int n, int i, int k){
            if(cur.size() + (n - i + 1) < k){
                return;
            }
            if(cur.size() == k){
                res.add(new ArrayList<>(cur));
                return;
            }
            cur.add(i);
            dfs(n, i + 1, k);
            cur.remove(cur.size() - 1);
            dfs(n, i + 1, k);
        }

        public Solution(){

        }
    }

    public static void main(String[] args) {
        T77_240615 t77240615 = new T77_240615();
        T77_240615.Solution solution = new Solution();
        System.out.println(solution.combine(2, 1));
    }



}
