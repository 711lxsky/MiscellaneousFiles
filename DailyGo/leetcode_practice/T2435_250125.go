package leetcode_practice

func numberOfPaths(grid [][]int, k int) int {
	MOD := int(1e9 + 7)
	m, n := len(grid), len(grid[0])
	dp := make([][][]int, m+1)
	for i := range dp {
		dp[i] = make([][]int, n+1)
		for j := range dp[i] {
			dp[i][j] = make([]int, k)
		}
	}
	dp[0][1][0] = 1
	for i, row := range grid {
		for j, x := range row {
			for d := 0; d < k; d++ {
				dp[i+1][j+1][(d+x)%k] = (dp[i+1][j][d] + dp[i][j+1][d]) % MOD
			}
		}
	}
	return dp[m][n][0]
}
