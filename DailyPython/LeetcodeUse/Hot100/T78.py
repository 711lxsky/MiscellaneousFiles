from ast import List

# 迭代枚举
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        weight = 1 << n
        result = []
        for mask in range(weight) :
            set = []
            for i in range(n):
                if mask >> i & 1 > 0:
                    set.append(nums[i])
            result.append(set)
        return result

# 递归回溯
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        set = []
        self.dfs(0, nums, set, res)
        return res
    
    def dfs(self, cur: int, nums: List[int], set: List[int], res: List[List[int]]):
        if cur == len(nums):
            res.append(set[:])
            return
        set.append(nums[cur])
        self.dfs(cur + 1, nums, set, res)
        set.pop()
        self.dfs(cur + 1, nums, set, res)