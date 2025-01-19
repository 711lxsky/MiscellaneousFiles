package leetcode_practice

import "math"

func minFallingPathSum2(grid [][]int) int {
	// 本质还是二维dp
	n := len(grid)
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			dp[i][j] = math.MaxInt32
		}
	}
	for i := 0; i < n; i++ {
		dp[0][i] = grid[0][i]
	}
	for i := 1; i < n; i++ {
		for j := 0; j < n; j++ {
			for k := 0; k < n; k++ {
				if k != j {
					dp[i][j] = min(dp[i][j], dp[i-1][k]+grid[i][j])
				}
			}
		}
	}
	res := math.MaxInt32
	for i := 0; i < n; i++ {
		res = min(res, dp[n-1][i])
	}
	return res
}
