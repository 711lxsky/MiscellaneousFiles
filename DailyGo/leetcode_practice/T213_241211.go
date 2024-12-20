package leetcode_practice

func rob(nums []int) int {
	// 其实也可以看作是 偷第1家且不偷最后一家 或者 不偷第1家偷剩下所有的
	n := len(nums)
	return max(nums[0]+robBase(nums, 2, n-1), robBase(nums, 1, n))
}

func robBase(nums []int, start, end int) int {
	prev, cur := 0, 0
	for i := start; i < end; i++ {
		prev, cur = cur, max(prev+nums[i], cur)
	}
	return cur
}

func baseRob(nums []int) int {
	// 计算从start位置开始，到end位置结束的能够拿到的最大金额
	n := len(nums)
	prev, cur := 0, 0
	for i := 0; i < n; i++ {
		prev, cur = cur, max(prev+nums[i], cur)
	}
	return cur
}
