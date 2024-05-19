package LeetCode_Classic150

func averageOfLevels(root *TreeNode) []float64 {
	var (
		treeRecord []*TreeNode
		res        []float64
	)
	treeRecord = []*TreeNode{root}
	for len(treeRecord) > 0 {
		curSize := len(treeRecord)
		rev := float64(0)
		for i := 0; i < curSize; i++ {
			curNode := treeRecord[0]
			treeRecord = treeRecord[1:]
			if curNode.Left != nil {
				treeRecord = append(treeRecord, curNode.Left)
			}
			if curNode.Right != nil {
				treeRecord = append(treeRecord, curNode.Right)
			}
			rev += float64(curNode.Val)
		}
		rev /= float64(curSize)
		res = append(res, rev)
	}
	return res
}
