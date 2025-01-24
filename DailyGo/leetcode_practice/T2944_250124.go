package leetcode_practice

import "slices"

func minimumCoins(prices []int) int {
	n := len(prices)
	for i := (n+1)/2 - 1; i > 0; i-- {
		prices[i-1] += slices.Min(prices[i : i*2+1])
	}
	return prices[0]
}
