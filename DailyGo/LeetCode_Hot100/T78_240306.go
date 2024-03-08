package LeetCode_Hot100

// 迭代枚举
func subsets1(nums []int) [][]int {
	n := len(nums)
	weight := 1 << n
	var ans [][]int
	for mask := 0; mask < weight; mask++ {
		var set []int
		for i, num := range nums {
			if mask>>i&1 > 0 {
				set = append(set, num)
			}
		}
		ans = append(ans, append([]int(nil), set...))
	}
	return ans
}

// 递归回溯
func subsets(nums []int) (ans [][]int) {
	n := len(nums)
	var (
		set []int
		dfs func(cur int)
	)
	dfs = func(cur int) {
		if cur == n {
			ans = append(ans, append([]int(nil), set...))
			return
		}
		set = append(set, nums[cur])
		dfs(cur + 1)
		set = set[:len(set)-1]
		dfs(cur + 1)
	}
	dfs(0)
	return
}
