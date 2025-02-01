package leetcode_practice

import "math"

func lengthOfLongestSubsequence(nums []int, target int) int {
	// 动规 + 滚动数组
	dp := make([]int, target+1)
	for i := range dp {
		dp[i] = math.MinInt32
	}
	dp[0] = 0
	for _, num := range nums {
		// 注意这里需要从后向前改变滚动数组的值
		for i := target; i >= num; i-- {
			dp[i] = max(dp[i], dp[i-num]+1)
		}
	}
	if dp[target] == math.MinInt32 {
		return -1
	}
	return dp[target]
}
