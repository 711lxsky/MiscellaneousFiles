import collections
from typing import List


# 深度优先
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = collections.defaultdict(list)
        visited = [0] * numCourses
        result = list()
        valid = True
        for pre in prerequisites:
            graph[pre[1]].append(pre[0])

        def dfs(u: int):
            nonlocal valid
            visited[u] = 1
            for v in graph[u]:
                if visited[v] == 0:
                    dfs(v)
                    if not valid:
                        return
                elif visited[v] == 1:
                    valid = False
                    return
            visited[u] = 2
            result.append(u)

        for i in range(numCourses):
            if valid and not visited[i]:
                dfs(i)
        return valid
