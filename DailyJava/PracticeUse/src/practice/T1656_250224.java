package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1656_250224 {

    class OrderedStream {

        int[] stream;
        Map<Integer, String> record;
        int ptr;
        public OrderedStream(int n) {
            stream = new int[n + 1];
            record = new HashMap<>();
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            this.record.put(idKey, value);
            stream[idKey] = idKey;
            List<String> res = new ArrayList<>();
            if(ptr == idKey){
                int i = ptr;
                while(i < stream.length && stream[i] == i){
                    res.add(record.get(i));
                    i ++;
                }
                ptr = i;
            }
            return res;
        }
    }

}
