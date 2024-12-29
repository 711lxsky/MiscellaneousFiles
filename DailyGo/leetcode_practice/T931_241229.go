package leetcode_practice

import "math"

func minFallingPathSum(matrix [][]int) int {
	// 还是类似思路，二维网格dp，一样可以进行复用
	n := len(matrix)
	if n == 1 {
		return matrix[0][0]
	}
	res := math.MaxInt32
	for i := 1; i < n; i++ {
		for j := 0; j < n; j++ {
			if j == 0 {
				matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])
			} else if j == n-1 {
				matrix[i][j] += min(matrix[i-1][j-1], matrix[i-1][j])
			} else {
				matrix[i][j] += min(min(matrix[i-1][j-1], matrix[i-1][j]), matrix[i-1][j+1])
			}
			if i == n-1 {
				res = min(res, matrix[i][j])
			}
		}
	}
	return res
}
