package LeetCode_Hot100

func diameterOfBinaryTree(root *TreeNode) int {
	var getDiameter func(node *TreeNode) int
	ans := 1
	getDiameter = func(node *TreeNode) int {
		if node == nil {
			return 0
		}
		L, R := getDiameter(node.Left), getDiameter(node.Right)
		ans = getMax(ans, L+R+1)
		return getMax(L, R) + 1
	}
	getDiameter(root)
	return ans - 1
}

func getMax(a, b int) int {
	if a > b {
		return a
	}
	return b
}
