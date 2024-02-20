package LeetCode_Hot100

import "math"

//type TreeNode struct {
//	Val   int
//	Left  *TreeNode
//	Right *TreeNode
//}

func isValidBST(root *TreeNode) bool {
	return judgeBST(root, math.MinInt64, math.MaxInt64)
}

func judgeBST(cur *TreeNode, minVal, maxVal int) bool {
	if cur == nil {
		return true
	}
	if cur.Val <= minVal || cur.Val >= maxVal {
		return false
	}
	return judgeBST(cur.Left, minVal, cur.Val) && judgeBST(cur.Right, cur.Val, maxVal)
}
