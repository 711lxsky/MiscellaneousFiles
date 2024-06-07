package LeetCodeClassic150;

public class T208_240607 {

    class Trie {

        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie curNode = this;
            int len = word.length();
            // 定位到字符位置对应的子节点位置
            for(int i = 0; i < len; i ++){
                char c = word.charAt(i);
                int pos =  c - 'a';
                if(curNode.children[pos] == null){
                    // 子节点不存在， 新建一个
                    curNode.children[pos] = new Trie();
                }
                // 再落到下一层
                curNode = curNode.children[pos];
            }
            curNode.isEnd = true;
        }

        public boolean search(String word) {
            Trie resNode = this.searchPrefix(word);
            return resNode != null && resNode.isEnd;
        }

        public boolean startsWith(String prefix) {
            return this.searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix){
            // 针对每个字符去下到相应的子节点
            Trie curNode = this;
            int len = prefix.length();
            for(int i = 0; i < len; i ++){
                char c = prefix.charAt(i);
                int index = c - 'a';
                if(curNode.children[index] == null){
                    return null;
                }
                curNode = curNode.children[index];
            }
            return curNode;
        }
    }

}
