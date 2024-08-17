package practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class T20_240817 {

    class Solution {


        Map<Character, Character> record = Map.ofEntries(
                Map.entry(')', '('),
                Map.entry(']', '['),
                Map.entry('}', '{')
        );
        public boolean isValid(String s) {
            Deque<Character> myQue = new ArrayDeque<>();
            int n = s.length();
            for(int i = 0; i < n; i ++){
                char cur = s.charAt(i);
                if(record.containsKey(cur)){
                    if(myQue.isEmpty() || myQue.poll() != record.get(cur)){
                        return false;
                    }
                }
                else {
                    myQue.push(cur);
                }
            }
            return myQue.isEmpty();
        }
    }

}
