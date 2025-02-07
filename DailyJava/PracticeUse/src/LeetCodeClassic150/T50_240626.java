package LeetCodeClassic150;

public class T50_240626 {

    /**
     * 递归写法
     */
    class Solution1 {
        public double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
        }

        public double quickPow(double x, long N){
            if(N == 0){
                return 1.0;
            }
            double halfRes = quickPow(x, N / 2);
            return N % 2 == 0 ? halfRes * halfRes : halfRes * halfRes * x;
        }
    }


    /**
     * 迭代写法
     */
    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
        }

        public double quickPow(double x, long N){
            double res = 1.0;
            double contribute = x;
            while(N > 0){
                if(N % 2 != 0){
                    res *= contribute;
                }
                contribute *= contribute;
                N /= 2;
            }
            return res;
        }

    }


}
