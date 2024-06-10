package LeetCodeClassic150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T17_240610 {

    class Solution1 {

        private Map<Character, String> record = new HashMap<>();

        public List<String> letterCombinations(String digits) {
            record.put('2', "abc");
            record.put('3', "def");
            record.put('4', "ghi");
            record.put('5', "jkl");
            record.put('6', "mno");
            record.put('7', "pqrs");
            record.put('8', "tuv");
            record.put('9', "wxyz");
            int n = digits.length();
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                char alphabet = digits.charAt(i);
                String s = record.get(alphabet);
                int curS = s.length();
                if(ans.isEmpty()){
                    for(int j = 0; j < curS; j ++){
                        ans.add(s.charAt(j) + "");
                    }
                }else {
                    List<String> tmp = new ArrayList<>();
                    for(int j = 0; j < curS; j ++){
                        for (String an : ans) {
                            tmp.add(an + s.charAt(j));
                        }
                    }
                    ans = tmp;
                }
            }
            return ans;
        }
    }

    class Solution {

        public List<String> letterCombinations(String digits) {
            int n = digits.length();
            if(n == 0){
                return new ArrayList<>();
            }
            String [] record = new String[]{"", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            List<String> ans = new ArrayList<>();
            ans.add("");
            for(int i = 0; i< n; i ++){
                String s = record[digits.charAt(i) - '0'];
                int size = ans.size();
                for(int j = 0; j< size; j++){
                    String cur = ans.remove(0);
                    for(int k = 0; k < s.length(); k ++){
                        ans.add(cur + s.charAt(k));
                    }
                }
            }
            return ans;
        }
    }

}
