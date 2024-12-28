package leetcode_practice

func jewelleryValue(frame [][]int) int {
	/*
		因为只能向下或者向右，所以很简单的就是二维网格dp，当前位置的最大值是当前值加上上侧dp或者左侧dp的值
		并且将最上边和最左边的值进行初始化
	*/
	m, n := len(frame), len(frame[0])
	// 进行初始化
	for i := 1; i < m; i++ {
		frame[i][0] += frame[i-1][0]
	}
	for j := 1; j < n; j++ {
		frame[0][j] += frame[0][j-1]
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			frame[i][j] = max(frame[i-1][j], frame[i][j-1]) + frame[i][j]
		}
	}
	return frame[m-1][n-1]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
