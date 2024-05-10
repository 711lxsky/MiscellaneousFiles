package LeetCode_Hot100

/*
这里的思路和之前的不同路径比较像，也是只能向下或者向右

	所以当前位置状态只能从上一个位置或者左边一个位置得来，
	特殊： 1. 第一行位置只能由左边位置转移
	      2. 第一列位置只能由上边位置转移
*/
func minPathSum(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	dp := make([][]int, m)
	// 初始化状态
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		if i == 0 {
			dp[i][0] = grid[i][0]
			for j := 1; j < n; j++ {
				dp[i][j] = grid[i][j] + dp[i][j-1]
			}
		} else {
			dp[i][0] = grid[i][0] + dp[i-1][0]
		}
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = grid[i][j] + getMin(dp[i-1][j], dp[i][j-1])
		}
	}
	return dp[m-1][n-1]
}
