from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        max_pos, frontier,  cnt = 0, 0, 0
        for i in range(n - 1):
         if max_pos >= i:
            max_pos = max(max_pos, i + nums[i])
            if i == frontier:
               frontier = max_pos
               cnt += 1
        return cnt