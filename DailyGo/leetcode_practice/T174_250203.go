package leetcode_practice

func calculateMinimumHP(dungeon [][]int) int {
	m, n := len(dungeon), len(dungeon[0])
	dp := make([][]int, m+1)
	// 先初始化整个动规矩阵为最大值
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
		for j := 0; j <= n; j++ {
			dp[i][j] = 1 << 30
		}
	}
	dp[m][n-1], dp[m-1][n] = 1, 1
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			minCost := min(dp[i+1][j], dp[i][j+1])
			dp[i][j] = max(minCost-dungeon[i][j], 1)
		}
	}
	return dp[0][0]
}
