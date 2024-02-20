package LeetCode_Hot100

func kthSmallest1(root *TreeNode, k int) int {
	// 借助中序遍历
	var myStack []*TreeNode
	for {
		for root != nil {
			myStack = append(myStack, root)
			root = root.Left
		}
		root, myStack = myStack[len(myStack)-1], myStack[:len(myStack)-1]
		k--
		if k == 0 {
			return root.Val
		}
		root = root.Right
	}
}

// 这个方法是使用左子树节点数来定位目标数的位置

type BSTNumRecord struct {
	root    *TreeNode
	nodeNum map[*TreeNode]int
}

func (t *BSTNumRecord) getNumRecord(cur *TreeNode) int {
	if cur == nil {
		return 0
	}
	t.nodeNum[cur] = 1 + t.getNumRecord(cur.Left) + t.getNumRecord(cur.Right)
	return t.nodeNum[cur]
}

func (t *BSTNumRecord) kthSmallest(k int) int {
	cur := t.root
	for {
		leftChildNum := t.nodeNum[cur.Left]
		if leftChildNum < k-1 {
			cur = cur.Right
			k -= leftChildNum + 1
		} else if leftChildNum == k-1 {
			return cur.Val
		} else {
			cur = cur.Left
		}
	}
}

func kthSmallest(root *TreeNode, k int) int {
	t := &BSTNumRecord{root, map[*TreeNode]int{}}
	t.getNumRecord(root)
	return t.kthSmallest(k)
}
