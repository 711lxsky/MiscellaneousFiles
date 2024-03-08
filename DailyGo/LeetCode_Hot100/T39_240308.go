package LeetCode_Hot100

func combinationSum(candidates []int, target int) [][]int {
	var (
		ans         [][]int
		combination []int
		backtrack   func(int, int)
	)
	ans = [][]int{}
	combination = []int{}
	n := len(candidates)
	backtrack = func(index int, tar int) {
		if index == n {
			return
		}
		if tar == 0 {
			ans = append(ans, append([]int(nil), combination...))
			return
		}
		backtrack(index+1, tar)
		if tar-candidates[index] >= 0 {
			combination = append(combination, candidates[index])
			backtrack(index, tar-candidates[index])
			combination = combination[:len(combination)-1]
		}
	}
	backtrack(0, target)
	return ans
}
