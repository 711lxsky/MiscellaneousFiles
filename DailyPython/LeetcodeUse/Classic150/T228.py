from ast import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        n = len(nums)
        i = 0
        ans = list()
        while i < n :
            leftIndex = i
            i += 1
            while i < n and nums[i - 1] + 1 == nums[i] :
                i += 1
            strCur = str(nums[leftIndex])
            if leftIndex < i - 1 :
                strCur += "->" + str(nums[i - 1])
            ans.append(strCur)
        return ans