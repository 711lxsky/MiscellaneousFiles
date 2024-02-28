package LeetCode_Hot100

// 使用递归的方式，拿到前序根节点的位置作为左右子树分隔，构造
func buildTree1(preorder []int, inorder []int) *TreeNode {
	treeRecord := map[int]int{}
	for index, num := range inorder {
		treeRecord[num] = index
	}
	n := len(preorder)
	return getTree(preorder, inorder, 0, n-1, 0, n-1, treeRecord)
}

func getTree(preorder []int, inorder []int, pLeft int, pRight int, iLeft int, iRight int, record map[int]int) *TreeNode {
	if pLeft > pRight {
		return nil
	}
	pRootVal := preorder[pLeft]
	iRoot := record[pRootVal]
	leftChildSize := iRoot - iLeft
	cur := &TreeNode{pRootVal, nil, nil}
	cur.Left = getTree(preorder, inorder, pLeft+1, pLeft+leftChildSize, iLeft, iRoot-1, record)
	cur.Right = getTree(preorder, inorder, pLeft+1+leftChildSize, pRight, iRoot+1, iRight, record)
	return cur
}

// 使用迭代的方法，利用先序和中序的规律
func buildTree(preorder []int, inorder []int) *TreeNode {
	n := len(preorder)
	if n == 0 {
		return nil
	}
	var myStack []*TreeNode
	inorderIndex := 0
	root := &TreeNode{preorder[0], nil, nil}
	myStack = append(myStack, root)
	for i := 1; i < n; i++ {
		// 中序的前面是左子节点，直到遇见某个右子节点或遍历完左子树，栈顶元素就会和中序前段元素碰撞，以此构建右子树
		preorderVal, node := preorder[i], myStack[len(myStack)-1]
		if node.Val != inorder[inorderIndex] {
			node.Left = &TreeNode{preorderVal, nil, nil}
			myStack = append(myStack, node.Left)
		} else {
			for len(myStack) > 0 && myStack[len(myStack)-1].Val == inorder[inorderIndex] {
				node = myStack[len(myStack)-1]
				myStack = myStack[:len(myStack)-1]
				inorderIndex++
			}
			node.Right = &TreeNode{preorderVal, nil, nil}
			myStack = append(myStack, node.Right)
		}
	}
	return root
}
