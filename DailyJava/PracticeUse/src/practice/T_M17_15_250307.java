package practice;

import java.util.*;
import java.util.function.BiFunction;

public class T_M17_15_250307 {

    class Solution {
        public String longestWord(String[] words) {
            String res = "";
            List<String> wordList = Arrays.asList(words);
            //按字符长度从大到小排列，相同长度的字符，按字典序正序排列，这样第一个返回的是满足题意要求的字符
            wordList.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
            for (String target : wordList) {
                if (dfs(target, 0, wordList)) return target;
            }
            return res;

        }

        /**
         * @param target   待处理的目标单词
         * @param start    该目标单词目前处理到的的下标索引，初始化的时候是0，从该单词的第一个字符开始
         * @param wordList 包含这个目标单词的所有单词的列表
         * @return
         */
        private boolean dfs(String target, int start, List<String> wordList) {
            if (start == target.length()) return true;//当下标到达字符的结尾时，说明这个是满足条件的
            for (int end = start; end < target.length(); end++) {
                //下面这一行是为了排除目标单词target本身，题意要求由其他的至少两个单词组成
                //当遍历的时候只有一轮，一直没找到其他的目标单词，这个目标单词做为一个候选词，需要被排除掉
                if (end - start + 1 == target.length()) continue;
                String prev = target.substring(start, end + 1);//切出来[start,end]之间的字符作为一个候选单词进入下一轮递归
                //这个切出来的单词是在单词列表&&剩下的单词也在单词列表（可能需要再切）
                if (wordList.contains(prev) && dfs(target, end + 1, wordList)) return true;
            }
            return false;
        }
    }

}
