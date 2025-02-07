package LeetCodeClassic150;

import java.util.PriorityQueue;

public class T295_240716 {

    class MedianFinder {

        /**
         * 用两个堆，前一半大根堆存小数；后一般小根堆存大数
         */
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> big;

        public MedianFinder() {
            this.small = new PriorityQueue<>((a, b) -> b - a);
            this.big = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if(small.isEmpty() || num <= small.peek()){
                small.offer(num);
                if(small.size() > big.size() + 1){
                    big.offer(small.poll());
                }
            }
            else {
                big.offer(num);
                if(big.size() > small.size()){
                    small.offer(big.poll());
                }
            }
        }

        public double findMedian() {
            if(small.size() == big.size()){
                return (small.peek() + big.peek()) / 2.0;
            }
            else {
                return (double)small.peek();
            }
        }
    }

}
