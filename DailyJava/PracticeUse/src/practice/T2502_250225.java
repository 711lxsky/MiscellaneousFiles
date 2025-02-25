package practice;

import java.util.Arrays;

public class T2502_250225 {

    class Allocator {

        private int n;
        private int[] memory;

        public Allocator(int n) {
            this.n = n;
            this.memory = new int[n];
        }

        public int allocate(int size, int mID) {
            int cnt = 0;
            for(int i = 0; i < n; i ++){
                if(memory[i] != 0){
                    cnt = 0;
                    continue;
                }
                cnt ++;
                if(cnt == size){
                    Arrays.fill(memory, i - size + 1, i + 1, mID);
                    return i - size + 1;
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int res = 0;
            for(int i = 0; i < n; i ++){
                if(memory[i] == mID){
                    memory[i] = 0;
                    res ++;
                }
            }
            return res;
        }
    }

}
