class Trie:

    def __init__(self):
        self.chid = [None] * 26
        self.isEnd = False


    def searchPrefix(self, prefix : str) -> "Trie":
        node = self
        for ch in prefix:
            ch = ord(ch) - ord('a')
            if not node.chid[ch]:
                return None
            node = node.chid[ch]
        return node


    def insert(self, word: str) -> None:
        node = self
        for ch in word:
            ch = ord(ch) - ord('a')
            if not node.chid[ch]:
                node.chid[ch] = Trie()
            node = node.chid[ch]
        node.isEnd = True

    def search(self, word: str) -> bool:
        node = self.searchPrefix(word)
        return node is not None and node.isEnd

    def startsWith(self, prefix: str) -> bool:
        return self.searchPrefix(prefix) is not None
