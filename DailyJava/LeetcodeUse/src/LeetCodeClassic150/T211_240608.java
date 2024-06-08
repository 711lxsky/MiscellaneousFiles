package LeetCodeClassic150;

public class T211_240608 {

    class WordDictionary {

        private WordDictionary[] children;
        private boolean isEnd;

        public WordDictionary() {
            this.children = new WordDictionary[26];
        }

        public void addWord(String word) {
            WordDictionary node = this;
            int len = word.length();
            for(int i = 0; i < len; i ++){
                char curChar = word.charAt(i);
                int index = curChar - 'a';
                if(node.children[index] == null){
                    node.children[index] = new WordDictionary();
                }
                node = node.children[index];

            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return this.search(word, this, 0);
        }

        private boolean search(String word, WordDictionary node, int index){
            // 当前已经到达最后位置
            if(index == word.length()){
                return node.isEnd;
            }
            char curChar = word.charAt(index);
            if(curChar != '.'){
                WordDictionary nextNode = node.children[curChar - 'a'];
                return nextNode != null && search(word, nextNode, index + 1);
            }
            for(int i = 0; i < 26; i ++){
                WordDictionary nextNode = node.children[i];
                if(nextNode != null && search(word, nextNode, index + 1)){
                    return true;
                }
            }
            return false;
        }
    }

}
