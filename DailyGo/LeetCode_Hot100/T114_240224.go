package LeetCode_Hot100

// 递归
func flatten1(root *TreeNode) {
	list := preorderErgodic(root)
	n := len(list)
	for i := 1; i < n; i++ {
		pre, cur := list[i-1], list[i]
		pre.Left, pre.Right = nil, cur
	}
}

func preorderErgodic(cur *TreeNode) []*TreeNode {
	var list []*TreeNode
	if cur != nil {
		list = append(list, cur)
		list = append(list, preorderErgodic(cur.Left)...)
		list = append(list, preorderErgodic(cur.Right)...)
	}
	return list
}

// 迭代, 前序遍历和链表展开分开进行
func flatten2(root *TreeNode) {
	var treeList []*TreeNode
	var myStack []*TreeNode
	node := root
	for node != nil || len(myStack) != 0 {
		for node != nil {
			treeList = append(treeList, node)
			myStack = append(myStack, node)
			node = node.Left
		}
		node = myStack[len(myStack)-1]
		myStack = myStack[:len(myStack)-1]
		node = node.Right
	}
	n := len(treeList)
	for i := 1; i < n; i++ {
		pre, cur := treeList[i-1], treeList[i]
		pre.Left, pre.Right = nil, cur
	}
}

// 迭代， 前序遍历和链表展开同时进行
func flatten3(root *TreeNode) {
	if root == nil {
		return
	}
	stack := []*TreeNode{root}
	var pre *TreeNode
	for len(stack) > 0 {
		cur := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if pre != nil {
			pre.Left, pre.Right = nil, cur
		}
		left, right := cur.Left, cur.Right
		if right != nil {
			stack = append(stack, right)
		}
		if left != nil {
			stack = append(stack, left)
		}
		pre = cur
	}
}

// O(1)解法， 借助前驱节点
func flatten(root *TreeNode) {
	cur := root
	for cur != nil {
		if cur.Left != nil {
			processor := cur.Left
			for processor.Right != nil {
				processor = processor.Right
			}
			processor.Right = cur.Right
			cur.Right = cur.Left
			cur.Left = nil
		}
		cur = cur.Right
	}
}
