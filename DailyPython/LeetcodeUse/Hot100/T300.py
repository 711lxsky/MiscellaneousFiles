from ast import List
import bisect


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        g = []
        for x in nums:
            i = bisect.bisect_left(g, x)
            if i == len(g):
                g.append(x)
            else:
                g[i] = x
        return len(g)