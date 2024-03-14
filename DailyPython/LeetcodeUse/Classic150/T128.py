from ast import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        mySet = set(nums)
        n = len(nums)
        ans = 0
        for num in nums:
            if num - 1 not in mySet:
                cur = 0
                while num in mySet:
                    cur += 1
                    num += 1
                ans = max(ans, cur)
        return ans