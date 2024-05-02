package LeetCode_Hot100

import (
	"slices"
	"sort"
)

// 记忆化搜索
func lengthOfLIS1(nums []int) int {
	n := len(nums)
	if n == 0 {
		return 0
	}
	memory := make([]int, n)
	var dfs func(i int) int
	dfs = func(i int) int {
		num := &memory[i]
		if *num > 0 {
			return *num
		}
		res := 0
		for j, x := range nums[:i] {
			if x < nums[i] {
				res = max(res, dfs(j))
			}
		}
		res++
		*num = res
		return res
	}
	ans := 0
	for i := 0; i < n; i++ {
		ans = max(ans, dfs(i))
	}
	return ans
}

// 递推
func lengthOfLIS2(nums []int) int {
	f := make([]int, len(nums))
	for i, x := range nums {
		for j, y := range nums[:i] {
			if y < x {
				f[i] = max(f[i], f[j])
			}
		}
		f[i]++
	}
	return slices.Max(f)
}

// 二分
func lengthOfLIS(nums []int) int {
	g := []int{}
	for _, x := range nums {
		j := sort.SearchInts(g, x)
		if j == len(g) {
			g = append(g, x)
		} else {
			g[j] = x
		}
	}
	return len(g)
}
