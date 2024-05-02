package LeetCode_Classic150

import (
	"sort"
)

// 递归写法
func countNodes1(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return countNodes1(root.Left) + countNodes1(root.Right) + 1
}

// 二分搜索 + 位运算
func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}
	level := 0
	for node := root; node.Left != nil; node = node.Left {
		level++
	}
	return sort.Search(1<<(level+1), func(i int) bool {
		if i <= 1<<level {
			return false
		}
		bits := 1 << (level - 1)
		node := root
		for node != nil && bits > 0 {
			if bits&i == 0 {
				node = node.Left
			} else {
				node = node.Right
			}
			bits >>= 1
		}
		return node == nil
	}) - 1
}
