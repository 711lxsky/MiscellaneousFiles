package LeetCodeClassic150;

import java.util.HashSet;
import java.util.Set;

public class P12_T380_2311213 {

    class RandomizedSet {
        Set<Integer> record;
        public RandomizedSet() {
            record = new HashSet<>();
        }

        public boolean insert(int val) {
            return record.add(val);
        }

        public boolean remove(int val) {
            return record.remove(val);
        }

        public int getRandom() {
            return 0;
        }
    }
}
