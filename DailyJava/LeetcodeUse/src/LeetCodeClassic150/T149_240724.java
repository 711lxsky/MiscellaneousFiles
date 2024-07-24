package LeetCodeClassic150;

import java.util.HashMap;
import java.util.Map;

public class T149_240724 {

    class Solution {

        // 斜率来算
        public int maxPoints(int[][] points) {
            int n = points.length;
            if(n <= 2){
                // 一条直线
                return n;
            }
            int res = 0;
            for(int i = 0; i < n; i ++){
                if(res > n / 2 || res >= n - i){
                    break;
                }
                int x = points[i][0], y = points[i][1];
                Map<Integer, Integer> record = new HashMap<>();
                for(int j = i + 1; j < n; j ++){
                    int xi = points[j][0], yi = points[j][1];
                    int xChange = x - xi;
                    int yChange = y - yi;
                    if(xChange == 0){
                        yChange = 1;
                    } else if(yChange == 0){
                        xChange = 1;
                    }
                    if(xChange < 0){
                        xChange = -xChange;
                        yChange = -yChange;
                    }
                    int xyGcd = gcd(Math.abs(xChange), Math.abs(yChange));
                    xChange /= xyGcd;
                    yChange /= xyGcd;
                    int tar = yChange + 711 * xChange;
                    record.put(tar, record.getOrDefault(tar, 0) + 1);
                }
                int max = 0;
                for(Map.Entry<Integer, Integer> entry : record.entrySet()){
                    int time = entry.getValue();
                    max = Math.max(max, time + 1);
                }
                res = Math.max(res, max);
            }
            return res;
        }

        public int gcd(int a, int b){
            return b != 0 ? gcd(b, a % b) : a;
        }
    }

}
