package leetcode_practice

func maxMoves(grid [][]int) (ans int) {
	/*
		二维dp，移动的方式是只能从左往右，和可以向上或者向下
		所以（第一列排除边界）是： 当前单元格 i,j 可以由 i-1,j-1\ i,j-1\ i+1,j-1 转移而来
		但是这里需要注意的是需要记录到达某个位置的最多步骤，而且是可以从第一列的任一一格出发
	*/
	m, n := len(grid), len(grid[0])
	vis := make([][]bool, m)
	for i := 0; i < m; i++ {
		vis[i] = make([]bool, n)
	}
	// 外层管理列
	for j := 1; j < n; j++ {
		// 内层是行位置
		for i := 0; i < m; i++ {
			// 三个位置查找
			for p := -1; p <= 1; p++ {
				if i+p < 0 || i+p >= m {
					continue
				}
				if grid[i][j] > grid[i+p][j-1] && (j == 1 || vis[i+p][j-1]) {
					vis[i][j] = true
					ans = j
					break
				}
			}
		}
	}
	return ans
}
