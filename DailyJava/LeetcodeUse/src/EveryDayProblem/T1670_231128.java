package EveryDayProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class T1670_231128 {

    /**
     * 考虑使用两个双端队列
     * 注意应该保持两个队列的元素数量具有一致性或者前一个队列多一个
     */
    class FrontMiddleBackQueue {

        Deque<Integer> left;
        Deque<Integer> right;
        public FrontMiddleBackQueue() {
            this.left = new ArrayDeque<>();
            this.right = new ArrayDeque<>();
        }

        public void pushFront(int val) {
            if(left.size() > right.size()){
                right.addFirst(left.pollLast());
            }
            left.addFirst(val);
        }

        public void pushMiddle(int val) {
            // 左边数量大于右边，即奇数，先弹出左边最后一个到右边
            if(left.size() > right.size()){
                right.addFirst(left.pollLast());
            }
            left.addLast(val);
        }

        public void pushBack(int val) {
            // 维持右边数量只可能比左边小1或者相等
            if(left.isEmpty()){
                left.addLast(val);
                return;
            }
            if(right.size() >= left.size()){
                left.addLast(right.pollFirst());
            }
            right.addLast(val);
        }

        public int popFront() {
            // 左边弹出之前，数量只可能大于等于右边
            if(left.size() == right.size() && ! right.isEmpty()){
                left.addLast(right.pollFirst());
            }
            if(left.isEmpty()){
                return -1;
            }
            return left.pollFirst();
        }

        public int popMiddle() {
            // 按照之前的策略，只会左边大一或者相等
            if(left.size() == right.size() && ! left.isEmpty()){
                int res = left.pollLast();
                left.addLast(right.pollFirst());
                return res;
            }
            if(left.isEmpty()) {
                return -1;
            }
            return left.pollLast();
        }

        public int popBack() {
            if(right.isEmpty()){
                if(left.isEmpty()){
                    return -1;
                }
            }
            if(left.size() > right.size()){
                right.addFirst(left.pollLast());
            }
            return right.pollLast();
        }
    }
}
