package leetcode_practice

import "math"

func maximumCostSubstring(s string, chars string, vals []int) int {
	// 将 values 值存入哈希表中
	record, lenChs := map[byte]int{}, len(chars)
	for i := 0; i < lenChs; i++ {
		record[chars[i]] = vals[i]
	}
	prev, res := 0, math.MinInt32
	n := len(s)
	for i := 0; i < n; i++ {
		ch := s[i]
		value := 0
		if val, has := record[ch]; has {
			value = val
		} else {
			value = int(ch-'a') + 1
		}
		prev = max(prev+value, value)
		res = max(res, prev)
	}
	return max(res, 0)
}
