package leetcode_practice

import "math"

func maximumAmount(coins [][]int) int {
	// 最多可以不选 2 次， 那么状态分别是 0， 1， 2次
	n := len(coins[0])
	dp := make([][3]int, n+1)
	for j := range dp {
		dp[j] = [3]int{math.MinInt32 / 2, math.MinInt32 / 2, math.MinInt32 / 2}
	}
	dp[1] = [3]int{}
	for _, row := range coins {
		for j, x := range row {
			dp[j+1][2] = max(max(max(dp[j][2]+x, dp[j+1][2]+x), dp[j][1]), dp[j+1][1])
			dp[j+1][1] = max(max(max(dp[j][1]+x, dp[j+1][1]+x), dp[j][0]), dp[j+1][0])
			dp[j+1][0] = max(dp[j][0]+x, dp[j+1][0]+x)
		}
	}
	return dp[n][2]
}
