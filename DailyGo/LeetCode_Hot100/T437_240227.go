package LeetCode_Hot100

// bfs 递归遍历寻找
func pathSum1(root *TreeNode, targetSum int) int {
	if root == nil {
		return 0
	}
	cnt := getSum(root, targetSum)
	cnt += pathSum1(root.Left, targetSum) + pathSum1(root.Right, targetSum)
	return cnt
}

func getSum(cur *TreeNode, tar int) int {
	if cur == nil {
		return 0
	}
	cnt, curVal := 0, cur.Val
	if curVal == tar {
		cnt++
	}
	return cnt + getSum(cur.Left, tar-curVal) + getSum(cur.Right, tar-curVal)
}

// 前缀和式递归
func pathSum(root *TreeNode, targetSum int) (ans int) {
	prefix := map[int64]int{0: 1}
	var dfs func(*TreeNode, int64)
	dfs = func(node *TreeNode, cur int64) {
		if node == nil {
			return
		}
		cur += int64(node.Val)
		ans += prefix[cur-int64(targetSum)]
		prefix[cur]++
		dfs(node.Left, cur)
		dfs(node.Right, cur)
		prefix[cur]--
		return
	}
	dfs(root, 0)
	return
}
