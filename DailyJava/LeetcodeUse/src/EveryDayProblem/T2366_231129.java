package EveryDayProblem;

import java.util.TreeSet;

public class T2366_231129 {


    class SmallestInfiniteSet {
        // 考虑使用一个TreeMap保持添加的序列有序，再加一个游标即可

        TreeSet<Integer> mySet;
        int index;
        public SmallestInfiniteSet() {
            mySet = new TreeSet<>(
                    //(a, b) -> a - b
            );
            index = 1;
        }

        public int popSmallest() {
            if(mySet.isEmpty()){
                return index ++;
            }
            int setMin = mySet.pollFirst();
            return setMin;
        }

        public void addBack(int num) {
            if(num < index){
                mySet.add(num);
            }
        }
    }


}
