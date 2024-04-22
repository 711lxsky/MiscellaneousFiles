from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        profit = [0] * n
        profit[0] = 0
        profit[1] = nums[0]
        for i in range(2, n):
            profit[i] = max(profit[i - 1], profit[i - 2] + nums[i - 1])
        return max(profit[-1], profit[-2] + nums[-1])