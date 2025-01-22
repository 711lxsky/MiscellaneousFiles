package leetcode_practice

import "sort"

func maxCoins(piles []int) int {
	sort.Ints(piles)
	n := len(piles)
	ans := 0
	for i := n / 3; i < n; i += 2 {
		ans += piles[i]
	}
	return ans
}
