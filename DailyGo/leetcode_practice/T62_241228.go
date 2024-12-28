package leetcode_practice

func uniquePaths(m int, n int) int {
	// 二维网格dp, 但是这里可以使用滚动数组，节省空间
	dp := make([]int, n)
	dp[0] = 1
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if j >= 1 {
				/*
					其实可以这样考虑，当前计算的位置最后还是要加上上一行值和左侧的值，且仅与这两个值有关
					所有，我们可以直接重复利用上一行直接算好的值直接想加即可
				*/
				dp[j] += dp[j-1]
			}
		}
	}
	return dp[n-1]
}
