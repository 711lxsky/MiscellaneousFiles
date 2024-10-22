package Interview_practice

func maxAreaOfIsland(grid [][]int) int {
	// 广度优先遍历
	m, n := len(grid), len(grid[0])
	maxArea, queue := 0, [][]int{}
	dir := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] != 1 {
				continue
			}
			queue = append(queue, []int{i, j})
			cur := 0
			for len(queue) > 0 {
				curPos := queue[0]
				queue = queue[1:]
				x, y := curPos[0], curPos[1]
				if x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1 {
					continue
				}
				cur++
				grid[x][y] = 0
				for i := 0; i < 4; i++ {
					queue = append(queue, []int{x + dir[i][0], y + dir[i][1]})
				}
			}
			maxArea = max(maxArea, cur)
		}
	}
	return maxArea
}
