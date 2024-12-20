package leetcode_practice

var dirs = [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

func islandPerimeter(grid [][]int) int {
	// 其实可以这么看： 针对每个陆地，只要是不和其他岛屿相连的边，都可以算到周长中去
	res := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			res += cntOneLen(grid, i, j)
		}
	}
	return res
}

func cntOneLen(grid [][]int, i, j int) int {
	if grid[i][j] != 1 {
		return 0
	}
	cnt, m, n := 0, len(grid), len(grid[0])
	for _, dir := range dirs {
		nextRow, nextCol := i+dir[0], j+dir[1]
		if nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n || grid[nextRow][nextCol] == 0 {
			cnt++
		}
	}
	return cnt
}
