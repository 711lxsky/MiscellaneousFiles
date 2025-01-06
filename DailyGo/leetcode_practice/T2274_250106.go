package leetcode_practice

import "slices"

func maxConsecutive(bottom, top int, special []int) int {
	slices.Sort(special)
	n := len(special)
	ans := max(special[0]-bottom, top-special[n-1])
	for i := 1; i < n; i++ {
		ans = max(ans, special[i]-special[i-1]-1)
	}
	return ans
}
