package LeetCodeClassic150;

import java.util.*;

public class T127_240606 {

    class Solution {

        // 广度优先遍历， 每次针对某个词去换一个位置

        private Set<String> visited = new HashSet<>();
        private Queue<String> record = new LinkedList<>();
        private Set<String> wordSet = new HashSet<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            wordSet.addAll(wordList);
            if(!wordSet.contains(endWord)) {
                return 0;
            }
            record.offer(beginWord);
            visited.add(beginWord);
            int step = 0;
            while(! record.isEmpty()){
                int size = record.size();
                while(size -- > 0){
                    String curWord = record.poll();
                    if(bfs(curWord, endWord)){
                        return step + 1;
                    }
                }
                step ++;
            }
            return 0;
        }

        private boolean bfs(String curWord, String tarWord){
            StringBuilder sb = new StringBuilder(curWord);
            int len = curWord.length();
            for(int i = 0; i < len; i ++) {
                char curChar = sb.charAt(i);
                for(char swap = 'a'; swap <= 'z'; swap ++){
                    if(curChar == swap){
                        continue;
                    }
                    sb.setCharAt(i, swap);
                    String newWord = sb.toString();
                    if(wordSet.contains(newWord)){
                        if(newWord.equals(tarWord)){
                            return true;
                        }
                        if(!visited.contains(newWord)){
                            record.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
                sb.setCharAt(i, curChar);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(strings);
        System.out.println(new T127_240606().new Solution().ladderLength(beginWord, endWord, wordList));
    }

}
