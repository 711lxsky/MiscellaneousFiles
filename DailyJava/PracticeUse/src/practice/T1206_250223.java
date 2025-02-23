package practice;

import java.util.Arrays;
import java.util.Random;

public class T1206_250223 {

    class SkiplistNode {
        int val;
        SkiplistNode[] next;

        public SkiplistNode(int val, int maxLevel){
            this.val = val;
            this.next = new SkiplistNode[maxLevel];
        }
    }

    class Skiplist {

        int MAX_LEVEL = 32;
        double P = 0.25;
        private SkiplistNode head;
        private int level;
        private Random random;

        public Skiplist() {
            this.head = new SkiplistNode(-1, MAX_LEVEL);
            this.level = 0;
            this.random = new Random();
        }

        public boolean search(int target) {
            SkiplistNode cur = this.head;
            // 从高层往低层进行查找
            for(int i = level - 1; i >= 0; i --){
                while (cur.next[i] != null && cur.next[i].val < target){
                    cur = cur.next[i];
                }
            }
            cur = cur.next[0];
            if(cur != null && cur.val == target){
                return true;
            }
            return false;
        }

        public void add(int num) {
            SkiplistNode[] updates = new SkiplistNode[MAX_LEVEL];
            Arrays.fill(updates, head);;
            SkiplistNode cur = head;
            for(int i = level - 1; i >= 0; i --){
                while(cur.next[i] != null && cur.next[i].val < num){
                    cur = cur.next[i];
                }
                updates[i] = cur;
            }
            int lv = randomLevel();
            level = Math.max(level, lv);
            SkiplistNode newNode = new SkiplistNode(num, lv);
            for(int i = 0; i < lv; i ++){
                newNode.next[i] = updates[i].next[i];
                updates[i].next[i] = newNode;
            }
        }

        public boolean erase(int num) {
            SkiplistNode[] updates = new SkiplistNode[MAX_LEVEL];
            SkiplistNode cur = head;
            for(int i = level - 1; i >= 0; i --){
                while(cur.next[i] != null && cur.next[i].val < num){
                    cur = cur.next[i];
                }
                updates[i] = cur;
            }
            cur = cur.next[0];
            if(cur == null || cur.val != num){
                return false;
            }
            for(int i = 0; i < level; i ++){
                if(updates[i].next[i] != cur){
                    break;
                }
                updates[i].next[i] = cur.next[i];
            }
            while(level > 1 && head.next[level - 1] == null){
                level --;
            }
            return true;
        }

        private int randomLevel() {
            int lv = 1;
            while(random.nextDouble() < P && lv < MAX_LEVEL){
                lv ++;
            }
            return lv;
        }
    }

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */

}
