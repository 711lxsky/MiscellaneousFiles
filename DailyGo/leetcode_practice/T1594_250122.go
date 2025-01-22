package leetcode_practice

func maxProductPath(grid [][]int) int {
	// 使用动规记录某个位置的最大值和最小值
	m, n := len(grid), len(grid[0])
	maxDP, minDP := make([][]int, m), make([][]int, m)
	for i := 0; i < m; i++ {
		maxDP[i] = make([]int, n)
		minDP[i] = make([]int, n)
	}
	maxDP[0][0] = grid[0][0]
	minDP[0][0] = grid[0][0]
	// 初始化第一行
	for i := 1; i < n; i++ {
		maxDP[0][i], minDP[0][i] = maxDP[0][i-1]*grid[0][i], minDP[0][i-1]*grid[0][i]
	}
	// 初始化第一列
	for j := 1; j < m; j++ {
		maxDP[j][0], minDP[j][0] = maxDP[j-1][0]*grid[j][0], minDP[j-1][0]*grid[j][0]
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if grid[i][j] < 0 {
				maxDP[i][j] = min(minDP[i-1][j], minDP[i][j-1]) * grid[i][j]
				minDP[i][j] = max(maxDP[i-1][j], maxDP[i][j-1]) * grid[i][j]
			} else {
				maxDP[i][j] = max(maxDP[i-1][j], maxDP[i][j-1]) * grid[i][j]
				minDP[i][j] = min(minDP[i-1][j], minDP[i][j-1]) * grid[i][j]
			}
		}
	}
	if maxDP[m-1][n-1] < 0 {
		return -1
	} else {
		return maxDP[m-1][n-1] % 1000000007
	}
}
