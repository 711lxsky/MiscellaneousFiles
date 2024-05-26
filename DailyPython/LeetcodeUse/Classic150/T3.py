class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left, right, n = 0, 0, len(s)
        record, ans = {}, 0
        while right < n :
            if s[right] in record:
                left = max(left, record[s[right]] + 1)
            record[s[right]] = right
            ans = max(ans, right - left + 1)
            right += 1
        return ans
