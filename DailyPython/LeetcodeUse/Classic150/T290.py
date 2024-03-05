class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        if len(pattern) != len(words):
            return False
        recordForP = dict()
        recordForW = dict()
        for ch, word in zip(pattern, words):
            if (ch in recordForP and recordForP[ch] != word) or (word in recordForW and recordForW[word] != ch):
                return False
            recordForP[ch] = word
            recordForW[word] = ch
        return True


