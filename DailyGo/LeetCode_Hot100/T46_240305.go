package LeetCode_Hot100

func permute(nums []int) [][]int {
	// 使用回溯，下一次递归的时候改变需要交换的位置
	var (
		res       [][]int
		backtrack func([]int, int)
	)
	n := len(nums)
	backtrack = func(nums []int, cur int) {
		if cur == n {
			res = append(res, append([]int(nil), nums...))
		}
		for i := cur; i < n; i++ {
			nums[i], nums[cur] = nums[cur], nums[i]
			backtrack(nums, cur+1)
			nums[i], nums[cur] = nums[cur], nums[i]
		}
	}
	backtrack(nums, 0)
	return res
}
