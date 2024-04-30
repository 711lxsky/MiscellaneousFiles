package LeetCode_Hot100

func wordBreak(s string, wordDict []string) bool {
	wordDictRecord := make(map[string]bool)
	for _, word := range wordDict {
		wordDictRecord[word] = true
	}
	n := len(s)
	dp := make([]bool, n+1)
	dp[0] = true
	for i := 1; i <= n; i++ {
		for j := 0; j < i; j++ {
			if dp[j] && wordDictRecord[s[j:i]] {
				dp[i] = true
				break
			}
		}
	}
	return dp[n]
}

// wordBreak优化版：使用动态规划判断给定字符串是否可以被字典中的单词拆分。
func wordBreak1(s string, wordDict []string) bool {
	// 构建字典记录所有单词
	wordDictRecord := make(map[string]bool)
	for _, word := range wordDict {
		wordDictRecord[word] = true
	}

	// 字典树，用于优化性能
	wordDictTrie := newTrie()
	for word := range wordDictRecord {
		wordDictTrie.insert(word)
	}

	// 动态规划数组，dp[i]表示s[0:i]是否可以被字典中的单词拆分
	n := len(s)
	dp := make([]bool, n+1)
	dp[0] = true
	for i := 1; i <= n; i++ {
		for j := 0; j < i; j++ {
			// 利用字典树优化，判断s[j:i]是否在字典中
			if wordDictTrie.search(s[j:i]) {
				dp[i] = dp[i] || dp[j]
			}
		}
	}

	return dp[n]
}

// Trie树节点
type node struct {
	children [26]*node
	isWord   bool
}

// Trie树
type trie struct {
	root *node
}

// newTrie返回一个新的空Trie树
func newTrie() *trie {
	return &trie{root: &node{}}
}

// insert将单词插入Trie树
func (t *trie) insert(word string) {
	curr := t.root
	for _, r := range word {
		index := r - 'a'
		if curr.children[index] == nil {
			curr.children[index] = &node{}
		}
		curr = curr.children[index]
	}
	curr.isWord = true
}

// search在Trie树中查找单词
func (t *trie) search(word string) bool {
	curr := t.root
	for _, r := range word {
		index := r - 'a'
		if curr.children[index] == nil {
			return false
		}
		curr = curr.children[index]
	}
	return curr.isWord
}
