package LeetCode_Classic150

/*
原本想的是直接换序走，但是没有考虑子节点的顺序也发生了变化
所以最好还是先规矩遍历， 然后判一下当前的方向， 然后 reverse 一下即可
*/
func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	treeRecord := []*TreeNode{root}
	res := make([][]int, 0)
	dir := 0
	var (
		curLevel []int
		curSize  int
	)
	for len(treeRecord) > 0 {
		curSize, curLevel = len(treeRecord), []int{}
		for i := 0; i < curSize; i++ {
			curNode := treeRecord[0]
			treeRecord = treeRecord[1:]
			if curNode.Left != nil {
				treeRecord = append(treeRecord, curNode.Left)
			}
			if curNode.Right != nil {
				treeRecord = append(treeRecord, curNode.Right)
			}
			curLevel = append(curLevel, curNode.Val)
		}
		if dir%2 != 0 {
			reverse(curLevel)
		}
		res = append(res, curLevel)
		dir++
	}
	return res
}

func reverse(nums []int) {
	for i, j := 0, len(nums); i <= j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}
