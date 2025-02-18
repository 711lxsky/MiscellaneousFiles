package LeetCodeClassic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2080_250218 {

    class RangeFreqQuery {

        Map<Integer, List<Integer>> record = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for(int i = 0; i < arr.length; i ++){
                record.putIfAbsent(arr[i], new ArrayList<>());
                record.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> nums = record.getOrDefault(value, new ArrayList<>());
            int l = findLeft(nums, left);
            int r = findRight(nums, right);
            return r - l;
        }

        public int findLeft(List<Integer> nums, int left){
            int low = 0, high = nums.size() - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(nums.get(mid) < left){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public int findRight(List<Integer> nums, int right){
            int low = 0, high = nums.size() - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(nums.get(mid) <= right){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            return low;
        }
    }


}
