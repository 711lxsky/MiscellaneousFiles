package LeetCode_Hot100

import "math"

// 递归
func maxPathSum(root *TreeNode) int {
	maxSum := math.MinInt64
	var getMaxPath func(*TreeNode) int
	getMaxPath = func(cur *TreeNode) int {
		if cur == nil {
			return 0
		}
		leftPath := getMax(getMaxPath(cur.Left), 0)
		rightPath := getMax(getMaxPath(cur.Right), 0)
		pathSum := cur.Val + leftPath + rightPath
		maxSum = getMax(maxSum, pathSum)
		return cur.Val + getMax(leftPath, rightPath)
	}
	getMaxPath(root)
	return maxSum
}
