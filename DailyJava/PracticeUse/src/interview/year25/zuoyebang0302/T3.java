package interview.year25.zuoyebang0302;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T3 {

    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt(), q = in.nextInt();
            int[] colors = new int[n];
            for(int i = 0; i < n; i ++){
                colors[i] = in.nextInt();
            }
            int[] leftTime = new int[n];
            Set<Integer> timeRecord = new HashSet<>();
            for(int i = 0; i < n; i ++){
                timeRecord.add(colors[i]);
                leftTime[i] = timeRecord.size();
            }
            timeRecord.clear();
            int[] rightTime = new int[n];
            for(int i = n - 1; i >= 0; i --){
                timeRecord.add(colors[i]);
                rightTime[n - i + 1] = timeRecord.size();
            }
            int leftCut = 0, rightCut = 0;
            for(int t = 0; t < q; t ++){
                char dir = (char) in.nextByte();
                int len = in.nextInt();
                int time = 0;
                if(dir == 'L'){
                    if(len >= n){
                        time = leftTime[n-1];
                    }else if(leftCut + len >= n){
                        time = leftTime[n - 1] - leftTime[leftCut] + leftTime[(leftCut + len) % n];
                    }else {
                        time = leftTime[len - 1] - leftTime[leftCut];
                    }
                    leftCut = (leftCut + len) % n;
                }
                else {
                    if (len >= n) {
                        time = rightTime[n - 1];
                    } else if (rightCut + len >= n) {
                        time = rightTime[n - 1] - rightTime[rightCut] + rightTime[(rightCut + len) % n];
                    } else {
                        time = rightTime[len - 1] - rightTime[rightCut];
                    }
                    rightCut = (rightCut + len) % n;

                }
                System.out.println(time);
            }
        }
    }

}
