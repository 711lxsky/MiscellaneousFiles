package LeetCode_Classic150

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedArrayToBST(nums []int) *TreeNode {
	// 使用二分法建树
	return getBST(0, len(nums), nums)
}

func getBST(left int, right int, nums []int) *TreeNode {
	if right < 0 || left >= len(nums) {
		return nil
	}
	mid := left + (right-left)/2
	leftChild := getBST(left, mid-1, nums)
	rightChild := getBST(mid+1, right, nums)
	var curPar *TreeNode = &TreeNode{nums[mid], leftChild, rightChild}
	return curPar
}
