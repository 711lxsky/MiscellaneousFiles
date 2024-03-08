from ast import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = list()
        def backtrack(cur : int):
            if cur == n:
                res.append(nums[:])
            for i in range(cur, n):
                nums[i], nums[cur] = nums[cur], nums[i]
                backtrack(cur+1)
                nums[i], nums[cur] = nums[cur], nums[i]
        backtrack(0)
        return res