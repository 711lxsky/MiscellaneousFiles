package LeetCode_Hot100

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 二叉树先序遍历morris实现
func preorderTraversal(root *TreeNode) (res []int) {
	for root != nil {
		if root.Left != nil {
			processor := root.Left
			for processor.Right != nil && processor.Right != root {
				processor = processor.Right
			}
			// 左子树安全
			if processor.Right == nil {
				res = append(res, root.Val)
				processor.Right = root
				root = root.Left
			} else { // 左子树已经遍历完全
				processor.Right = nil
				root = root.Right
			}
		} else { // 没有左子树
			res = append(res, root.Val)
			root = root.Right
		}
	}
	return
}

// 二叉树中序遍历morris实现
func inorderTraversal(root *TreeNode) (res []int) {
	// 使用morris遍历
	for root != nil {
		// 先看有无左子节点，需要寻找的是当前节点的中序遍历前驱节点
		if root.Left != nil {
			processor := root.Left
			for processor.Right != nil && processor.Right != root {
				processor = processor.Right
			}
			if processor.Right == nil {
				processor.Right = root
				root = root.Left
			} else { // 已经遍历完了左子树
				res = append(res, root.Val)
				processor.Right = nil
				root = root.Right
			}
		} else { // 没有左子树，直接往右走
			res = append(res, root.Val)
			root = root.Right
		}
	}
	return
}

// 二叉树后序遍历morris实现
func postorderTraversal(root *TreeNode) (res []int) {
	// 这个比较麻烦，需要实现倒序、收割右子树
	reveseInts := func(nums []int) {
		n := len(nums)
		for i := 0; i < n/2; i++ {
			nums[i], nums[n-i-1] = nums[n-i-1], nums[i]
		}
	}
	addPath := func(node *TreeNode) {
		size := len(res)
		for node != nil {
			res = append(res, node.Val)
			node = node.Right
		}
		reveseInts(res[size:])
	}
	for root != nil {
		if root.Left != nil { // 左子树存在
			processor := root.Left
			for processor.Right != nil && processor.Right != root {
				processor = processor.Right
			}
			if processor.Right == nil {
				processor.Right = root
				root = root.Left
			} else {
				processor.Right = nil
				addPath(root.Left)
				root = root.Right
			}
		} else {
			root = root.Right
		}
	}
	addPath(root)
	return
}
