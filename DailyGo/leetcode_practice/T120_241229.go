package leetcode_practice

import "math"

func minimumTotal(triangle [][]int) (ans int) {
	// 这里其实本质上还是一个网格DP，还是可以复用原有的二维数组
	ans = math.MaxInt32
	m, n := len(triangle), 2
	if m == 1 {
		return triangle[0][0]
	}
	for i := 1; i < m; i++ {
		for j := 0; j < n; j++ {
			if j == 0 {
				triangle[i][j] += triangle[i-1][j]
			} else if j == n-1 {
				triangle[i][j] += triangle[i-1][j-1]
			} else {
				triangle[i][j] += min(triangle[i-1][j-1], triangle[i-1][j])
			}
			if i == m-1 {
				ans = min(ans, triangle[i][j])
			}
		}
		n++
	}
	return
}
