from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dir = [[0,1], [0,-1], [1,0], [-1,0]]
        m, n = len(grid), len(grid[0])
        cnt = 0
        my_queue = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    cnt += 1
                    my_queue.append([i, j])
                    while my_queue:
                        x, y = my_queue.pop(0)
                        for d in dir:
                            nx, ny = x + d[0], y + d[1]
                            if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] == '1':
                                grid[nx][ny] = '0'
                                my_queue.append([nx, ny])
        return cnt