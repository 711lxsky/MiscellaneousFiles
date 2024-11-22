package Interview_practice

func getSubarrayBeauty(nums []int, k int, x int) []int {
	// 因为数据给的范围在 -50 ~ 50 之间，所以可以直接用桶来计数
	offset, n := 50, len(nums)
	ans, bucket := make([]int, n-k+1), make([]int, offset*2+1)
	for i := 0; i < k-1; i++ {
		bucket[nums[i]+offset]++
	}
	for i := k - 1; i < n; i++ {
		// 进入窗口
		bucket[nums[i]+offset]++
		for left, j := x, 0; j < offset; j++ {
			left -= bucket[j]
			if left <= 0 {
				ans[i-k+1] = j - offset
				break
			}
		}
		// 移出窗口
		bucket[nums[i-k+1]+offset]--
	}
	return ans
}
