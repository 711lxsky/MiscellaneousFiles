package LeetCodeClassic150;

import java.util.*;

public class T212_240609 {

    class Solution {

        int [][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        Set<String> ans;

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            for(String word : words){
                trie.insert(word);
            }
            this. ans = new HashSet<>();
            int row = board.length, col = board[0].length;
            for(int i = 0; i < row; i ++){
                for(int j = 0 ;j < col; j ++){
                    this.dfs(board, trie, i, j);
                }
            }
            return new ArrayList<>(ans);
        }

        private void dfs(char[][] board, Trie cur, int i1, int j1){
            if(! cur.children.containsKey(board[i1][j1])){
                return;
            }
            char ch = board[i1][j1];
            cur = cur.children.get(ch);
            if(! "".equals(cur.word)){
                ans.add(cur.word);
            }
            board[i1][j1] = '@';
            for(int [] dir : direction){
                int i2 = i1 + dir[0], j2 = j1 + dir[1];
                if(i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length){
                    dfs(board, cur, i2, j2);
                }
            }
            board[i1][j1] = ch;
        }
    }

    class Trie {
        String word;
        Map<Character, Trie> children;
        boolean isWord;

        public Trie(){
            this.word = "";
            this.children = new HashMap<Character, Trie>();
        }

        public void insert(String word){
            Trie curNode = this;
            int len = word.length();
            for(int i = 0; i < len; i ++){
                char curChar = word.charAt(i);
                if(! curNode.children.containsKey(curChar)){
                    curNode.children.put(curChar, new Trie());
                }
                curNode = curNode.children.get(curChar);
            }
            curNode.word = word;
        }
    }

}
