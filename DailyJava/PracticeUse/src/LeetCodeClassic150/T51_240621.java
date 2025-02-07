package LeetCodeClassic150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T51_240621 {

    class Solution {

        Set<Integer> col = new HashSet<>();
        Set<Integer> forward1 = new HashSet<>();
        Set<Integer> forward2 = new HashSet<>();

        int n;
        int res = 0;

        public int totalNQueens(int n) {
            this.n = n;
            backtrace(0);
            return res;
        }

        public void backtrace(int index){
            if(index == this.n){
                res ++;
            }
            else {
                for(int i = 0; i < n; i ++){
                    if(col.contains(i)){
                        continue;
                    }
                    int f1 = index + i;
                    if(forward1.contains(f1)){
                        continue;
                    }
                    int f2 = index - i;
                    if(forward2.contains(f2)){
                        continue;
                    }
                    col.add(i);
                    forward1.add(f1);
                    forward2.add(f2);
                    backtrace(index + 1);
                    col.remove(i);
                    forward1.remove(f1);
                    forward2.remove(f2);
                }
            }
        }

    }

}
