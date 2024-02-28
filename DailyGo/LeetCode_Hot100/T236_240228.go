package LeetCode_Hot100

// 递归写法
func lowestCommonAncestor1(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if root.Val == p.Val || root.Val == q.Val {
		return root
	}
	left, right := lowestCommonAncestor1(root.Left, p, q), lowestCommonAncestor1(root.Right, p, q)
	if left != nil && right != nil {
		return root
	}
	if left != nil {
		return left
	}
	return right
}

// 记录父节点
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	parent := map[int]*TreeNode{}
	visit := map[int]bool{}

	var dfs func(node *TreeNode)
	dfs = func(cur *TreeNode) {
		if cur == nil {
			return
		}
		if cur.Left != nil {
			parent[cur.Left.Val] = cur
			dfs(cur.Left)
		}
		if cur.Right != nil {
			parent[cur.Right.Val] = cur
			dfs(cur.Right)
		}
	}
	dfs(root)
	for p != nil {
		visit[p.Val] = true
		p = parent[p.Val]
	}
	for q != nil {
		if visit[q.Val] {
			return q
		}
		q = parent[q.Val]
	}
	return nil
}
