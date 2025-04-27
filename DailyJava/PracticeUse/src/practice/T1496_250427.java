package practice;

import java.util.HashSet;
import java.util.Set;

public class T1496_250427 {

    class Solution {
        public boolean isPathCrossing(String path) {
            Set<int[]> record = new HashSet<>();
            int[] pre = new int[]{0, 0};
            record.add(pre);
            for(int i = 0; i < path.length(); i ++){
                char ch = path.charAt(i);
                int nextX = pre[0], nextY = pre[1];
                if(ch == 'N'){
                    nextY += 1;
                }else if(ch == 'S'){
                    nextY -= 1;
                }else if(ch == 'E'){
                    nextX += 1;
                }else {
                    nextX -= 1;
                }
                int[] nextPos = new int[]{nextX, nextY};
                if(record.contains(nextPos)){
                    return true;
                }
                record.add(nextPos);
                pre = nextPos;
            }
            return false;
        }
    }

}
