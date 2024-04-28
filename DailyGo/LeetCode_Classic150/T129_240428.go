package LeetCode_Classic150

func sumNumbers(root *TreeNode) int {
	return getSumForSonNodes(root, 0)
}

func getSumForSonNodes(root *TreeNode, sum int) int {
	if root == nil {
		return 0
	}
	if isLeaf(root) {
		return sum*10 + root.Val
	}
	return getSumForSonNodes(root.Left, sum*10+root.Val) + getSumForSonNodes(root.Right, sum*10+root.Val)
}

func isLeaf(node *TreeNode) bool {
	if node.Left == nil && node.Right == nil {
		return true
	}
	return false
}
