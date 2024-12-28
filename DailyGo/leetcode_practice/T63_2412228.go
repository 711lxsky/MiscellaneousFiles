package leetcode_practice

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	// 相比于普通情况下只是增加了当前位置可能是障碍物的情况，本质思想还是一致的
	m, n := len(obstacleGrid), len(obstacleGrid[0])
	dp := make([]int, n)
	if obstacleGrid[0][0] == 1 {
		return 0
	} else {
		dp[0] = 1
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if obstacleGrid[i][j] == 1 {
				dp[j] = 0
			} else {
				if j >= 1 {
					dp[j] += dp[j-1]
				}
			}

		}
	}
	return dp[n-1]
}
