from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        maxArrive = 0
        for i in range (0, n):
            if maxArrive < i:
                return False
            maxArrive = max(maxArrive, i + nums[i])
            if maxArrive >= n - 1:
                return True
        return True