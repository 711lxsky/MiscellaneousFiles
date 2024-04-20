from typing import List


class Solution:
    def generate(self, num_rows: int) -> List[List[int]]:
        ans = list()
        for i in range(num_rows):
            nums = list()
            for j in range(i + 1):
                if j == 0 or j == i:
                    nums.append(1)
                else:
                    nums.append(ans[i - 1][j - 1] + ans[i - 1][j])
            ans.append(nums)
        return ans