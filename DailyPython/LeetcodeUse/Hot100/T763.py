from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        record = [0] * 26
        n = len(s)
        for i in range(n) :
            record[ord(s[i]) - ord('a')] = i
        ans = list()
        start, end =  0, 0
        for index in range(n) :
            end = max(end, record[ord(s[index]) - ord('a')])
            if index == end:
                ans.append(end - start + 1)
                start = index + 1
        return ans
