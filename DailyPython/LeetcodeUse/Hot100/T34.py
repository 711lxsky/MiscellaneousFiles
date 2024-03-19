from ast import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        leftMost = self.binarySearch(nums, target, True)
        rightMost = self.binarySearch(nums, target, False) - 1
        n = len(nums)
        if leftMost > rightMost or leftMost < 0 or leftMost >= n or rightMost < 0 or rightMost >= n or nums[leftMost] != target or nums[rightMost] != target:
            return [-1, -1]
        return [leftMost, rightMost]


    def binarySearch(self, nums: List[int], tar: int, lower: bool) -> int:
        left = 0
        right = len(nums) - 1
        ans = len(nums)
        while left <= right:
            mid = left + (right - left) >> 1
            if nums[mid] > tar or (lower and nums[mid] >= tar):
                right = mid - 1
                ans = mid
            else :
                left = mid + 1
        return ans
