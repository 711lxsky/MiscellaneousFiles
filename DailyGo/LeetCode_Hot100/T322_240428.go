package LeetCode_Hot100

import (
	"math"
)

// 记忆化搜索
func coinChange1(coins []int, amount int) int {
	// 边界判断
	if amount < 1 {
		return 0
	}
	return internalCoinChange(coins, amount, make([]int, amount))
}

func internalCoinChange(coins []int, money int, cnts []int) int {
	// 当前路径不可行
	if money < 0 {
		return -1
	}
	// 金额已经凑齐
	if money == 0 {
		return 0
	}
	// 子问题中已经计算, 避免重复计算
	if cnts[money-1] != 0 {
		return cnts[money-1]
	}
	minCnt := math.MaxInt
	for _, coin := range coins {
		// 子问题执行
		changeRes := internalCoinChange(coins, money-coin, cnts)
		if changeRes != -1 {
			minCnt = cntMin(changeRes+1, minCnt)
		}
	}
	// 更新可行解
	if minCnt != math.MaxInt {
		cnts[money-1] = minCnt
	} else {
		cnts[money-1] = -1
	}
	return cnts[money-1]
}

func cntMin(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	for index, _ := range dp {
		dp[index] = amount + 1
	}
	dp[0] = 0
	n := len(coins)
	for i := 1; i <= amount; i++ {
		for j := 0; j < n; j++ {
			if coins[j] <= i {
				dp[i] = cntMin(dp[i], dp[i-coins[j]]+1)
			}
		}
	}
	if dp[amount] != amount+1 {
		return dp[amount]
	}
	return -1
}
