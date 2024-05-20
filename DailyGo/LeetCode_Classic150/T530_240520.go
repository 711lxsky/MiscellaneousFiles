package LeetCode_Classic150

func getMinimumDifference(root *TreeNode) int {
	var (
		treeNodeValsRecord []int
		minGap             int
	)
	treeNodeValsRecord, minGap = []int{}, 100001
	frontTravel(root, &treeNodeValsRecord)
	for i := len(treeNodeValsRecord) - 1; i > 0; i-- {
		minGap = minVal(minGap, treeNodeValsRecord[i]-treeNodeValsRecord[i-1])
	}
	return minGap
}

func frontTravel(cur *TreeNode, treeNodeVals *[]int) {
	if cur == nil {
		return
	}
	frontTravel(cur.Left, treeNodeVals)
	*treeNodeVals = append(*treeNodeVals, cur.Val)
	frontTravel(cur.Right, treeNodeVals)
	return
}

func minVal(a, b int) int {
	if a < b {
		return a
	}
	return b
}
