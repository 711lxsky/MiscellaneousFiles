package LeetCode_Hot100;

import java.util.*;

public class P2_T49_231202 {

    public static final Long myKey = 29L;
    public static final Long MOD = 1000000007L;
    // 借助哈希表来存储某个特殊键和对应的List下标
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<Long, List<String>> records = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs){
            int len = str.length();
            long key = 1;
            for(int j = 0 ; j < len ; j ++){
                key = (long) (str.charAt(j) - 'a' + 1) * myKey * key % MOD;
            }
            List<String> curGroup = records.get(key);
            if(null == curGroup){
                curGroup = new ArrayList<>();
            }
            curGroup.add(str);
            records.put(key, curGroup);
        }
        for(Map.Entry entry : records.entrySet()){
            res.add((List<String>) entry.getValue());
        }
        return res;
    }

    // 针对每个串直接排序后去看哈希表
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> records = new HashMap<>();
        for(String str : strs){
            char [] strCharArray = str.toCharArray();
            Arrays.sort(strCharArray);
            String orderStr = String.copyValueOf(strCharArray);
            List<String> curGroup = records.get(orderStr);
            if(null == curGroup){
                curGroup = new ArrayList<>();
            }
            curGroup.add(str);
            records.put(orderStr, curGroup);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry entry : records.entrySet()){
            res.add((List<String>) entry.getValue());
        }
        return res;
    }

}
