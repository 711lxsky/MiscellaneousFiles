package LeetCodeClassic150;

public class T190_240717 {

    public static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for(int i = 31; i >= 0 && n != 0; -- i){
                res |= (n & 1) << i;
                n >>>= 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        T190_240717.Solution solution = new T190_240717.Solution();
        System.out.println(solution.reverseBits(-3));
    }

}
