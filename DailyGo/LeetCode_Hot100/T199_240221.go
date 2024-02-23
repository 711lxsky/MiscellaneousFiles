package LeetCode_Hot100

// dfs
func rightSideView1(root *TreeNode) (ans []int) {
	var getRightViewForDFS func(*TreeNode, int)
	getRightViewForDFS = func(cur *TreeNode, depth int) {
		if cur == nil {
			return
		}
		if len(ans) == depth {
			ans = append(ans, cur.Val)
		}
		getRightViewForDFS(cur.Right, depth+1)
		getRightViewForDFS(cur.Left, depth+1)
	}
	getRightViewForDFS(root, 0)
	return ans
}

// bfs
func rightSideView(root *TreeNode) (ans []int) {
	if root == nil {
		return
	}
	var myQue []*TreeNode
	myQue = append(myQue, root)
	for len(myQue) != 0 {
		curSize := len(myQue)
		for i := 0; i < curSize; i++ {
			cur := myQue[0]
			myQue = myQue[1:]
			if cur.Left != nil {
				myQue = append(myQue, cur.Left)
			}
			if cur.Right != nil {
				myQue = append(myQue, cur.Right)
			}
			if i == curSize-1 {
				ans = append(ans, cur.Val)
			}
		}
	}
	return ans
}
