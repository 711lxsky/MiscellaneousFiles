from ast import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        record = {}
        for index, num in enumerate(nums):
            if num in record and index - record[num] <= k:
                return True
            record[num] = index
        return False

class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        mySet = set()
        for index, num in enumerate(nums):
            if index > k:
                mySet.remove(nums[index - k - 1])
            if num in mySet:
                return True
            mySet.add(num)
        return False