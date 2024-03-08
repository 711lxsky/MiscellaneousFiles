from ast import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        result = []
        path = []
        n = len(candidates)
        if n == 0:
            return []
        def getSum(begin: int, tar: int, path: List[int]):
            if tar == 0:
                result.append(path)
                return
            for index in range(begin, n):
                curTar = tar - candidates[index]
                if curTar < 0:
                    break
                getSum(index, curTar, path + [candidates[index]])
        getSum(0, target, path)
        return result
