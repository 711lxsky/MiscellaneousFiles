package LeetCode_Classic150

func buildTree(inorder []int, postorder []int) *TreeNode {
	n := len(postorder)
	if n == 0 {
		return nil
	}
	myStack := []*TreeNode{}
	inorderIndex := n - 1
	root := &TreeNode{postorder[n-1], nil, nil}
	myStack = append(myStack, root)
	for postorderIndex := n - 2; postorderIndex >= 0; postorderIndex-- {
		postorderVal := postorder[postorderIndex]
		node := myStack[len(myStack)-1]
		if node.Val != inorder[inorderIndex] {
			node.Right = &TreeNode{postorderVal, nil, nil}
			myStack = append(myStack, node.Right)
		} else {
			for len(myStack) > 0 && myStack[len(myStack)-1].Val == inorder[inorderIndex] {
				node = myStack[len(myStack)-1]
				myStack = myStack[:len(myStack)-1]
				inorderIndex--
			}
			node.Left = &TreeNode{Val: postorderVal}
			myStack = append(myStack, node.Left)
		}
	}
	return root
}
