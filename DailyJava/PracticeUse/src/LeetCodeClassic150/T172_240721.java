package LeetCodeClassic150;

public class T172_240721 {

    class Solution {
        public int trailingZeroes(int n) {
            int res = 0;
            while(n > 0){
                n /= 5;
                res += n;
            }
            return res;
        }
    }

}
