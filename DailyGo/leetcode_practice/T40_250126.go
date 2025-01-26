package leetcode_practice

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	var (
		ans         [][]int
		combination []int
		backtrack   func(int, int)
	)
	ans = [][]int{}
	combination = []int{}
	n := len(candidates)
	sort.Ints(candidates)
	backtrack = func(index int, tar int) {
		if tar == 0 {
			ans = append(ans, append([]int(nil), combination...))
		}
		for i := index; i < n; i++ {
			if tar-candidates[i] < 0 {
				break
			}
			// 元素相同，直接跳过
			if i > index && candidates[i] == candidates[i-1] {
				continue
			}
			combination = append(combination, candidates[i])
			backtrack(i+1, tar-candidates[i])
			combination = combination[:len(combination)-1]
		}
	}
	backtrack(0, target)
	return ans
}
