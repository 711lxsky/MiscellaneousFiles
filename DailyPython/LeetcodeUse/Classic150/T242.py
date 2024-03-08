class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        lenS = len(s)
        lenT = len(t)
        if lenS != lenT:
            return False
        cnt = [0] * 26
        for i in range(lenS):
            cnt[ord(s[i]) - ord('a')] += 1
        for j in range(lenT):
            cnt[ord(t[j]) - ord('a')] -= 1
            if cnt[ord(t[j]) - ord('a')] < 0:
                return False
        return True