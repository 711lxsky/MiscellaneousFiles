package practice;

/**
 * @Author yuyang
 * @Date 2024/11/13
 * @Description
 */
public class T2379_241113 {

    static class Solution {
        public int minimumRecolors(String blocks, int k) {
            int res = Integer.MAX_VALUE, cnt = 0, n = blocks.length();
            int i = 0;
            while(i < k - 1){
                if(blocks.charAt(i) == 'W'){
                    cnt ++;
                }
                i ++;
            }
            while(i < n){
                if(blocks.charAt(i) == 'W'){
                    cnt ++;
                }
                res = Math.min(res, cnt);
                if(blocks.charAt(i - k + 1) == 'W'){
                    cnt --;
                }
                i ++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(solution.minimumRecolors("WBWBBBW", 2));
    }

}
