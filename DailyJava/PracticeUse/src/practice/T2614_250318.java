package practice;

public class T2614_250318 {

    class Solution {
        public int diagonalPrime(int[][] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    if (i == j || i + j == nums.length - 1) {
                        if (isPrime(nums[i][j])) {
                            max = Math.max(max, nums[i][j]);
                        }
                    }
                }
            }
            return max;
        }

        public boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            int stop = (int) Math.sqrt(n);
            for (int i = 2; i <= stop; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
