from ast import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        record = {}
        n = len(nums)
        for i in range(n):
            if target - nums[i] in record:
                return [record[target - nums[i]], i]
            else:
                record[nums[i]] = i